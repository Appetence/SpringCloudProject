package com.ztx.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
@DefaultProperties(defaultFallback = "paymentInfo_Global_TimeoutHandler")//全局同一的降级方法
public class OrderController {
    @Value("${server.port}")
    private String port;
    @Resource
    private OrderService orderService;

    @PostMapping(value = "create")
    public CommentResult<Payment> create(@RequestBody Payment payment) {
        return orderService.create(payment);

    }
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "4000")})
    @GetMapping(value = "getPaymentById/get/{id}")
    public CommentResult<Payment> getPaymentById(@PathVariable(name = "id") Long id) {
        log.info("结果：{}",id);
        return  orderService.getPaymentById(id);
    }
   // @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",commandKey = "userGetKey")
    @GetMapping(value = "getPaymentByIds/get/{id}")
    public CommentResult<Payment> getPaymentByIds(@PathVariable(name = "id") Long id) {
        log.info("结果：{}",id);
        CommentResult<Payment>  list =  orderService.getPaymentById(id);
        log.info("等待返回");
        return list;
    }
    public CommentResult<Payment>  paymentInfo_TimeoutHandler(Long id){
        return new CommentResult<Payment>(405,"请求超时，降级启动");
    }
    @HystrixCommand
    @GetMapping(value = "getprot")
    public String getPort(int i ) {
        log.info("进来了");
        int res = 10/0;
        return port;
    }
    public String paymentInfo_Global_TimeoutHandler(){
        return "全局的降级走了";
    }
}
