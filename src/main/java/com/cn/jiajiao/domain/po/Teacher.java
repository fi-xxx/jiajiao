package com.cn.jiajiao.domain.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Teacher {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String teacherPhonum;
    private String teacherName;
    private String teacherSex;
    private String teacherIcon;
    private String teacherAddress;
    private String teacherExper;
    private String teacherSub;
    private String grade;
}
