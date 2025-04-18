package com.cn.jiajiao.domain.vo;

import lombok.Data;
import java.io.Serializable;

@Data
public class ParentVo implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Long id;
    private String phone;
    private String icon;
    private String accessToken;
    private String refreshToken;
}
