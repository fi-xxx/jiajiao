package com.cn.jiajiao.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cn.jiajiao.dao.RewardDao;
import com.cn.jiajiao.domain.po.Reward;
import com.cn.jiajiao.domain.vo.RewardVo;
import com.cn.jiajiao.service.RewardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RewardServiceImpl extends ServiceImpl<RewardDao, Reward> implements RewardService {

    @Override
    public List<RewardVo> listAll() {
        List<Reward> rewards = list();
        List<RewardVo> rewardVoList = BeanUtil.copyToList(rewards, RewardVo.class);

        for (int i = 0; i < rewards.size(); i++) {
            Date rawDate = rewards.get(i).getDate();
            if (rawDate != null) {
                String formattedDate = DateUtil.format(rawDate, "yyyy-MM-dd HH:mm:ss");
                rewardVoList.get(i).setDate(formattedDate);
            }
        }

        return rewardVoList;
    }
} 