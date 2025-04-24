package com.cn.jiajiao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cn.jiajiao.domain.po.Reward;
import com.cn.jiajiao.domain.vo.RewardVo;

import java.util.List;

public interface RewardService extends IService<Reward> {
    
    /**
     * 查询所有奖学券
     * @return 奖学券列表
     */
    List<RewardVo> listAll();
} 