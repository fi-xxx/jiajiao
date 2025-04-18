package com.cn.jiajiao.controller;

import com.cn.jiajiao.common.R;
import com.cn.jiajiao.domain.dto.ParentDto;
import com.cn.jiajiao.domain.vo.ParentVo;
import com.cn.jiajiao.domain.vo.TokenVo;
import com.cn.jiajiao.service.ParentService;
import com.cn.jiajiao.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parents")
@RequiredArgsConstructor
public class ParentController {

    private final TokenService tokenService;
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

    /**
     * 刷新访问令牌
     * @param tokenVo 包含refreshToken和phone的对象
     * @return 新的访问令牌
     */
    @PostMapping("/refresh")
    public R<TokenVo> refreshToken(@RequestBody TokenVo tokenVo) {
        String newAccessToken = tokenService.refreshAccessToken(tokenVo.getRefreshToken(), tokenVo.getPhone());
        tokenVo.setAccessToken(newAccessToken);
        return R.success(tokenVo);
    }

    /**
     * 注销登录
     * @param tokenVo 包含refreshToken的对象
     * @return 操作结果
     */
    @PostMapping("/logout")
    public R<Void> logout(@RequestBody TokenVo tokenVo) {
        tokenService.invalidateRefreshToken(tokenVo.getRefreshToken());
        return R.success(null);
    }

    @GetMapping()
    public R<Void> Hi(){
        System.out.println("Hi");
        return R.success("服务器没有问题!",null);
    }



} 