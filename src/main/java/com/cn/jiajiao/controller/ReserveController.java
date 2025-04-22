package com.cn.jiajiao.controller;


import com.cn.jiajiao.common.R;
import com.cn.jiajiao.domain.dto.ReserveDto;
import com.cn.jiajiao.service.ReserveService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
