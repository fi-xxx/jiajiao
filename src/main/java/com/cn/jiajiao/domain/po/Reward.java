package com.cn.jiajiao.domain.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("par_reward")
public class Reward {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String parentPhone;
    private String account;
    private Date date;
}
