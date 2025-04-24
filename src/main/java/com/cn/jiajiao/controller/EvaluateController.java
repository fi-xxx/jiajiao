package com.cn.jiajiao.controller;

import com.cn.jiajiao.common.R;
import com.cn.jiajiao.domain.dto.EvaluateDto;
import com.cn.jiajiao.domain.vo.EvaluateVo;
import com.cn.jiajiao.service.EvaluateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evaluates")
@RequiredArgsConstructor
public class EvaluateController {

    private final EvaluateService evaluateService;

    /**
     * 添加评价
     *
     * @param evaluateDto 评价信息
     * @return 操作结果
     */
    @PostMapping
    public R<String> addEvaluate(@RequestBody EvaluateDto evaluateDto) {
        boolean success = evaluateService.addEvaluate(evaluateDto);
        return success ? R.success("添加评价成功") : R.error("添加评价失败");
    }

    /**
     * 查询所有的老师评价信息
     *
     * @return 评价列表
     */
    @GetMapping
    public R<List<EvaluateVo>> getAllEvaluate() {
        List<EvaluateVo> evaluateVoList = evaluateService.getAllEvaluate();
        return R.success(evaluateVoList);
    }


    /**
     * 查询指定科目的老师评价信息
     * @param subject 科目
     * @return 评价列表
     */
    @GetMapping("/by-subject")
    public R<List<EvaluateVo>> getEvaluateBySubject(@RequestParam String subject) {
        List<EvaluateVo> evaluateVoList = evaluateService.getEvaluateBySubject(subject);
        //可能是参数错误查询为空，也可能是查询结果为空，二者没做区分
        return R.success(evaluateVoList);
    }
} 