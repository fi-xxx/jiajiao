package com.cn.jiajiao.controller;

import com.cn.jiajiao.common.R;
import com.cn.jiajiao.domain.dto.EvaluateDto;
import com.cn.jiajiao.service.EvaluateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/evaluates")
@RequiredArgsConstructor
public class EvaluateController {

    private final EvaluateService evaluateService;

    /**
     * 添加评价
     * @param evaluateDto 评价信息
     * @return 操作结果
     */
    @PostMapping
    public R<String> addEvaluate(@RequestBody EvaluateDto evaluateDto) {
        boolean success = evaluateService.addEvaluate(evaluateDto);
        return success ? R.success("添加评价成功") : R.error("添加评价失败");
    }
} 