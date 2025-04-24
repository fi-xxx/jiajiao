package com.cn.jiajiao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cn.jiajiao.domain.dto.EvaluateDto;
import com.cn.jiajiao.domain.po.Evaluate;
import com.cn.jiajiao.domain.vo.EvaluateVo;

import java.util.List;

public interface EvaluateService extends IService<Evaluate> {
    
    /**
     * 添加评价
     * @param evaluateDto 评价信息
     * @return 是否添加成功
     */
    boolean addEvaluate(EvaluateDto evaluateDto);

    /**
     * 查询所有的老师评价信息
     * @return 评价列表
     */
    List<EvaluateVo> getAllEvaluate();


    /**
     * 查询指定科目的老师评价信息
     * @param subject 科目
     * @return 评价列表
     */
    List<EvaluateVo> getEvaluateBySubject(String subject);

} 