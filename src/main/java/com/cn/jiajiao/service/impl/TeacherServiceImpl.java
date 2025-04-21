package com.cn.jiajiao.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cn.jiajiao.dao.TeacherDao;
import com.cn.jiajiao.domain.po.Teacher;
import com.cn.jiajiao.domain.vo.TeacherVo;
import com.cn.jiajiao.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl extends ServiceImpl<TeacherDao, Teacher> implements TeacherService {

    @Override
    public List<TeacherVo> getBySubject(String subject) {
        LambdaQueryWrapper<Teacher> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Teacher::getTeacherSub, subject);
        List<Teacher> teachers = list(wrapper);
        return convertToVoList(teachers);
    }

    @Override
    public List<TeacherVo> getBySubjectAndGrade(String subject, String grade) {
        LambdaQueryWrapper<Teacher> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Teacher::getTeacherSub, subject)
               .eq(Teacher::getGrade, grade);
        List<Teacher> teachers = list(wrapper);
        return convertToVoList(teachers);
    }

    /**
     * 将Teacher列表转换为TeacherVo列表
     * @param teachers Teacher列表
     * @return TeacherVo列表
     */
    private List<TeacherVo> convertToVoList(List<Teacher> teachers) {
        return teachers.stream().map(teacher -> {
            TeacherVo vo = new TeacherVo();
            BeanUtils.copyProperties(teacher, vo);
            return vo;
        }).collect(Collectors.toList());
    }
} 