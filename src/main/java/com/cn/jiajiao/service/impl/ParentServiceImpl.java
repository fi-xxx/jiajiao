package com.cn.jiajiao.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cn.jiajiao.common.exception.BusinessException;
import com.cn.jiajiao.common.utils.MD5Util;
import com.cn.jiajiao.dao.ParentDao;
import com.cn.jiajiao.domain.dto.ParentDto;
import com.cn.jiajiao.domain.po.Parent;
import com.cn.jiajiao.domain.vo.ParentVo;
import com.cn.jiajiao.service.ParentService;
import com.cn.jiajiao.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ParentServiceImpl extends ServiceImpl<ParentDao,Parent> implements ParentService {

    private final TokenService tokenService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean register(ParentDto parentDto) {
        // 检查手机号是否已注册
        LambdaQueryWrapper<Parent> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Parent::getPhone, parentDto.getPhone());
        if (this.count(queryWrapper) > 0) {
            throw new BusinessException("该手机号已注册");
        }

        // 创建新用户
        Parent parent = new Parent();
        parent.setPhone(parentDto.getPhone());
        // 密码加密
        parent.setPassword(MD5Util.encrypt(parentDto.getPassword()));
        // 设置默认头像
        parent.setIcon("default.jpg");
        
        return this.save(parent);
    }

    @Override
    public ParentVo login(ParentDto parentDto) {
        // 查询用户
        LambdaQueryWrapper<Parent> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Parent::getPhone, parentDto.getPhone())
                   .eq(Parent::getPassword, MD5Util.encrypt(parentDto.getPassword()));
        Parent parent = this.getOne(queryWrapper);
        
        if (parent == null) {
            throw new BusinessException("未注册/手机号,密码错误");
        }

        // 转换为VO对象
        ParentVo parentVo = new ParentVo();
        BeanUtils.copyProperties(parent, parentVo);
        
        // 生成token
        TokenService.TokenPair tokenPair = tokenService.generateTokens(parent.getId(), parent.getPhone());
        parentVo.setAccessToken(tokenPair.getAccessToken());
        parentVo.setRefreshToken(tokenPair.getRefreshToken());
        //当用户短时间内未登出多次登录，则会生成多个refreshToken，
        return parentVo;
    }
}
