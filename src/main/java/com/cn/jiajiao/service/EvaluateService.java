package com.cn.jiajiao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cn.jiajiao.domain.dto.EvaluateDto;
import com.cn.jiajiao.domain.po.Evaluate;

public interface EvaluateService extends IService<Evaluate> {
    
    /**
     * 添加评价
     * @param evaluateDto 评价信息
     * @return 是否添加成功
     */
    boolean addEvaluate(EvaluateDto evaluateDto);
} 