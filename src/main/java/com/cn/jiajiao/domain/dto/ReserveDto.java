package com.cn.jiajiao.domain.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ReserveDto {
    private String parentPhone;
    private String teacherPhone;
    private String teacherName;
    private String subject;
    private Date date;
}
