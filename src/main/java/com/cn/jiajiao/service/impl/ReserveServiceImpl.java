package com.cn.jiajiao.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cn.jiajiao.dao.ReserveDao;
import com.cn.jiajiao.domain.dto.ReserveDto;
import com.cn.jiajiao.domain.po.Reserve;
import com.cn.jiajiao.service.ReserveService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ReserveServiceImpl extends ServiceImpl<ReserveDao, Reserve> implements ReserveService {

    @Override
    public boolean bookTeacher(ReserveDto reserveDto) {
        Reserve reserve = new Reserve();
        BeanUtil.copyProperties(reserveDto, reserve);
        return save(reserve);
    }
}
