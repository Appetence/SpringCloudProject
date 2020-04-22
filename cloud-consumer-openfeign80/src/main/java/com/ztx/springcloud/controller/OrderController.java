package com.ztx.springcloud.controller;

import com.ztx.springcloud.entities.CommentResult;
import com.ztx.springcloud.entities.Payment;
import com.ztx.springcloud.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
@Slf4j
@RestController
@RequestMapping("OrderController")
public class OrderController {
    @Value("${server.port}")
    private String port;
    @Resource
    private OrderService orderService;

    @PostMapping(value = "create")
    public CommentResult<Payment> create(@RequestBody Payment payment) {
        return orderService.create(payment);

    }
    @GetMapping(value = "getPaymentById/get/{id}")
    public CommentResult<Payment> getPaymentById(@PathVariable(name = "id") Long id) {
        log.info("结果：{}",id);
        return  orderService.getPaymentById(id);
    }
    @GetMapping(value = "getprot")
    public String getPort() {
        log.info("进来了");
        return port;
    }
}
