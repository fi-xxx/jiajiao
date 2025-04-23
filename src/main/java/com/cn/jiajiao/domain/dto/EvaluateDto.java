package com.cn.jiajiao.domain.dto;


import lombok.Data;

import java.util.Date;

@Data
public class EvaluateDto {
    private String parentPhone;
    private String teacherPhone;
    private String content;
    private Date date;
    private String subject;
}
