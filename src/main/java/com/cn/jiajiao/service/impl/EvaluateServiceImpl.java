package com.cn.jiajiao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cn.jiajiao.dao.EvaluateDao;
import com.cn.jiajiao.domain.dto.EvaluateDto;
import com.cn.jiajiao.domain.po.Evaluate;
import com.cn.jiajiao.service.EvaluateService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EvaluateServiceImpl extends ServiceImpl<EvaluateDao, Evaluate> implements EvaluateService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addEvaluate(EvaluateDto evaluateDto) {
        Evaluate evaluate = new Evaluate();
        BeanUtils.copyProperties(evaluateDto, evaluate);
        return save(evaluate);
    }
} 