package com.ztx.springcloud.controller;

import cn.hutool.core.date.DateUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.Date;

@RestController
@RequestMapping("TimeServerController")
public class TimeServerController {


    @GetMapping("getTimeServer")
    public String getTimeServer() {
        return  DateUtil.now();
    }

    /**
     * 网关路由时间配置
     * @return
     */
    @GetMapping("getZoneDateTime")
    public ZonedDateTime getZoneDateTime(){
        ZonedDateTime zonedDateTime =  ZonedDateTime.now();
        System.out.println(zonedDateTime);
        //2020-04-22T07:00:14.029+08:00[Asia/Shanghai]
        return zonedDateTime;
    }
}
