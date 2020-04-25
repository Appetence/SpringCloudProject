package com.ztx.springcloud.controller;

import com.ztx.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class MessageController {
    @Resource
    private IMessageProvider iMessageProvider;
    @RequestMapping("sendMessage")
    public String sendMessage(){
        return iMessageProvider.send();
    }
}
