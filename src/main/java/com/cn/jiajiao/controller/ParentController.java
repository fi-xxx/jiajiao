package com.cn.jiajiao.controller;

import com.cn.jiajiao.common.R;
import com.cn.jiajiao.domain.dto.ParentDto;
import com.cn.jiajiao.domain.vo.ParentVo;
import com.cn.jiajiao.service.ParentService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parents")
@RequiredArgsConstructor
public class ParentController {

    private final ParentService parentService;

    @PostMapping("/register")
    public R<Boolean> register(@Validated @RequestBody ParentDto parentDto) {
        boolean result = parentService.register(parentDto);
        return R.success(result);
    }

    @PostMapping("/login")
    public R<ParentVo> login(@Validated @RequestBody ParentDto parentDto) {
        ParentVo parentVo = parentService.login(parentDto);
        return R.success(parentVo);
    }

    @GetMapping()
    public R<Void> Hi(){
        System.out.println("Hi");
        return R.success("服务器没有问题!",null);
    }
} 