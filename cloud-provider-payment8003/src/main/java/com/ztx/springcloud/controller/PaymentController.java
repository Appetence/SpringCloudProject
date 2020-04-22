package com.ztx.springcloud.controller;

import com.ztx.springcloud.entities.CommentResult;
import com.ztx.springcloud.entities.Payment;
import com.ztx.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String port;
    @PostMapping(value = "create")
    public CommentResult<Payment> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        if (result > 0) {
            return new CommentResult<Payment>(200, "成功");
        } else {
            return new CommentResult<Payment>(500, "新增失败");
        }
    }
    @GetMapping(value = "getPaymentById/get/{id}")
    public CommentResult<Payment> getPaymentById(@PathVariable(name = "id") Long id) {
        log.info("结果：{}",id);
        return new CommentResult<Payment>(200, port+":成功", paymentService.getPaymentById(id));
    }
    @GetMapping(value = "getprot")
    public String getPort() {
        log.info("进来了");
        return port;
    }
}
