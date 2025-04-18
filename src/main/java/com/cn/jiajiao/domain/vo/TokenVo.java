package com.cn.jiajiao.domain.vo;

import lombok.Data;

@Data
public class TokenVo {
    private String accessToken;
    private String refreshToken;
    private String phone;
} 