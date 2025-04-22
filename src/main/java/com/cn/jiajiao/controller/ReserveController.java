package com.cn.jiajiao.controller;


import com.cn.jiajiao.common.R;
import com.cn.jiajiao.domain.dto.ReserveDto;
import com.cn.jiajiao.domain.vo.ReserveVo;
import com.cn.jiajiao.service.ReserveService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/reserve")
@RequiredArgsConstructor
public class ReserveController {


    private final ReserveService reserveService;


    @PostMapping
    public R<String> reserve(@RequestBody ReserveDto reserveDto) {
        boolean isSave = reserveService.bookTeacher(reserveDto);
        if (isSave)
            return R.success("预约成功!");
        else return R.error("出错了,请联系后台管理员");
    }


    /**
     * 查询预约教师
     * @param parentPhone 家长电话
     * @return 预约的教师列表
     */
    @GetMapping
    public R<List<ReserveVo>> getByParentPhone(@RequestParam String parentPhone ){
        List<ReserveVo> reserveVoList = reserveService.getByParentPhone(parentPhone);
        if(reserveVoList==null||reserveVoList.size()==0)
            return R.error("你还没有预约教师哦");
        else return R.success(reserveVoList);
    }
}
