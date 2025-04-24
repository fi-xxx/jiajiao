package com.cn.jiajiao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cn.jiajiao.dao.RewardDao;
import com.cn.jiajiao.domain.po.Reward;
import com.cn.jiajiao.service.RewardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RewardServiceImpl extends ServiceImpl<RewardDao, Reward> implements RewardService {

    @Override
    public List<Reward> listAll() {
        return list();
    }
} 