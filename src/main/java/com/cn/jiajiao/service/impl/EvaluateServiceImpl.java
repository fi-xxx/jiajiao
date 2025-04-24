package com.cn.jiajiao.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cn.jiajiao.dao.EvaluateDao;
import com.cn.jiajiao.domain.dto.EvaluateDto;
import com.cn.jiajiao.domain.po.Evaluate;
import com.cn.jiajiao.domain.vo.EvaluateVo;
import com.cn.jiajiao.domain.vo.TeacherVo;
import com.cn.jiajiao.service.EvaluateService;
import com.cn.jiajiao.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EvaluateServiceImpl extends ServiceImpl<EvaluateDao, Evaluate> implements EvaluateService {

    //用于获取教师姓名
    private final TeacherService teacherService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addEvaluate(EvaluateDto evaluateDto) {
        Evaluate evaluate = new Evaluate();
        BeanUtils.copyProperties(evaluateDto, evaluate);
        return save(evaluate);
    }

    @Override
    public List<EvaluateVo> getAllEvaluate() {
        List<Evaluate> evaluateList = list(); // 获取所有评价
        return convertEvaluateListWithTeacherName(evaluateList);
    }


    @Override
    public List<EvaluateVo> getEvaluateBySubject(String subject) {
        if (StrUtil.isBlank(subject)) {
            return Collections.emptyList();
        }

        List<Evaluate> evaluateList = lambdaQuery()
                .eq(Evaluate::getSubject, subject)
                .list();

        return convertEvaluateListWithTeacherName(evaluateList);
    }

    private List<EvaluateVo> convertEvaluateListWithTeacherName(List<Evaluate> evaluateList) {
        if (CollUtil.isEmpty(evaluateList)) {
            return Collections.emptyList();
        }

        // 获取所有教师手机号
        Set<String> teacherPhones = evaluateList.stream()
                .map(Evaluate::getTeacherPhone)
                .filter(StrUtil::isNotEmpty)
                .collect(Collectors.toSet());

        // 批量查教师信息并构建 Map
        Map<String, String> teacherNameMap = teacherPhones.stream()
                .map(teacherService::getByPhone) // TeacherVo
                .filter(Objects::nonNull)
                .collect(Collectors.toMap(
                        TeacherVo::getTeacherPhone,
                        TeacherVo::getTeacherName
                ));

        // 转为 VO 并附加教师姓名
        return evaluateList.stream().map(e -> {
            EvaluateVo vo = BeanUtil.copyProperties(e, EvaluateVo.class);
            vo.setTeacherName(teacherNameMap.getOrDefault(e.getTeacherPhone(), "未知教师"));
            return vo;
        }).collect(Collectors.toList());
    }



} 