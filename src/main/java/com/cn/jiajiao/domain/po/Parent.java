package com.cn.jiajiao.domain.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Parent {
    @TableId(type = IdType.AUTO)
    private String id;
    @TableField("phonenum")
    private String phone;
    @TableField("paswd")
    private String password;
    private String icon;
    private String address;
}
