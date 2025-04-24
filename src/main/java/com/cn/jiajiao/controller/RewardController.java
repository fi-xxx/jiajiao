package com.cn.jiajiao.controller;

import com.cn.jiajiao.common.R;
import com.cn.jiajiao.domain.po.Reward;
import com.cn.jiajiao.service.RewardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rewords")
@RequiredArgsConstructor
public class RewardController {

    private final RewardService rewordService;

    /**
     * 查询所有奖学券
     * @return 奖学券列表
     */
    @GetMapping
    public R<List<Reward>> listAll() {
        List<Reward> rewords = rewordService.listAll();
        return R.success(rewords);
    }
} 