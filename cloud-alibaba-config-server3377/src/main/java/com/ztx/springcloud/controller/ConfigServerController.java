package com.ztx.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope//注意，只有此注解标注的位置才会变
public class ConfigServerController {
    @Value("${config.info}")
    private String info;
    @RequestMapping("getInfo")
    public String getInfo(){
        return info;
    }
}
