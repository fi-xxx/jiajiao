package com.cn.jiajiao.domain.vo;


import lombok.Data;

import java.util.Date;

@Data
public class EvaluateVo {
    private String parentPhone;
    private String teacherName;
    private String content;
    private Date date;
    private String subject;
}

