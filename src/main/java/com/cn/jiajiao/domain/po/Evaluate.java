package com.cn.jiajiao.domain.po;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class Evaluate {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String parentPhone;
    private String teacherPhone;
    private String content;
    private Date date;
    private String subject;
}
