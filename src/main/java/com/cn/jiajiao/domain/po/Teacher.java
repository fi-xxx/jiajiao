package com.cn.jiajiao.domain.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Teacher {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String teachPhonum;
    private String teachName;
    private String teachSex;
    private String teachIcon;
    private String teachAddress;
    private String teachExper;
    private String teachSub;
    private String grade;
}
