package com.ztx.springcloud.controller;

import com.ztx.springcloud.entities.CommentResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Value("${server.port}")
    private String port;
    @RequestMapping("getPort")
    public CommentResult<String> getPort(){
        return new CommentResult<>(200,"成功了",port);
    }
}
