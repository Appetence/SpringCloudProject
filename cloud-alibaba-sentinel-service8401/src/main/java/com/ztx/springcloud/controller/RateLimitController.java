package com.ztx.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.ztx.springcloud.entities.CommentResult;
import com.ztx.springcloud.entities.Payment;
import com.ztx.springcloud.handler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateLimitController {
    @GetMapping("byResource")
    @SentinelResource(value = "byResource", blockHandler = "byResource_block")
    public CommentResult byResource() {
        return new CommentResult(200, "成功", new Payment(1, "2233"));
    }

    public CommentResult byResource_block(BlockException blockException) {
        return new CommentResult(400, "失败:" + blockException.getClass().getName(), new Payment(5, "5555"));
    }

    @GetMapping("CustomerResource")//自定义异常处理
    @SentinelResource(value = "CustomerResource", blockHandler = "handlerExeception2",blockHandlerClass = CustomerBlockHandler.class)
    public CommentResult CustomerResource() {
        return new CommentResult(200, "成功", new Payment(1, "2233"));
    }
}
