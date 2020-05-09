package com.ztx.springcloud.controller;

import com.ztx.springcloud.config.ProvideService;
import com.ztx.springcloud.entities.CommentResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class PaymentController {
    @Value("${service-uri.nacos-user-server}")
    private String SERVER_URI;
    @Value("${server.port}")
    private String port;
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private ProvideService provideService;

    @RequestMapping("getPort")
    public CommentResult<String> getPort(){
        System.out.println(SERVER_URI);
        CommentResult<String> commentResult = restTemplate.getForObject(SERVER_URI+"getPort",CommentResult.class);
        return commentResult;
    }
    @RequestMapping("getPorts")
    public CommentResult<String> getPortOpenFegin(){
        System.out.println("进来啦9003");
        return provideService.getPort();
    }
}
