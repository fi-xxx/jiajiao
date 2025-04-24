package com.cn.jiajiao.domain.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("par_reward")
public class RewardVo {
    private String parentPhone;
    private String account;
    private String date;
}
