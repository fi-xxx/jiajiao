package com.cn.jiajiao.domain.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class Reserve {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String parentPhone;
    private String teacherPhone;
    private String teacherName;
    private String subject;
    private Date date;
}
