package com.cn.jiajiao.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.cn.jiajiao.domain.dto.ReserveDto;
import com.cn.jiajiao.domain.po.Reserve;
import com.cn.jiajiao.domain.vo.ReserveVo;

import java.util.List;

public interface ReserveService extends IService<Reserve> {

    /**
     * 预约
     * @param reserveDto 前端传来的dto
     * @return 是否预约成功
     */
    public boolean bookTeacher(ReserveDto reserveDto);


    public List<ReserveVo> getByParentPhone(String parentPhone);
}
