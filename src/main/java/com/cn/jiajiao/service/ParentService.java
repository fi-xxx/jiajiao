package com.cn.jiajiao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cn.jiajiao.domain.dto.ParentDto;
import com.cn.jiajiao.domain.po.Parent;
import com.cn.jiajiao.domain.vo.ParentVo;

public interface ParentService extends IService<Parent> {
    /**
     * 用户注册
     * @param parentDto 注册信息
     * @return 注册结果
     */
    boolean register(ParentDto parentDto);

    /**
     * 用户登录
     * @param parentDto 登录信息
     * @return 登录结果
     */
    ParentVo login(ParentDto parentDto);
}
