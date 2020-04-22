package com.ztx.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.ztx.springcloud.entities.CommentResult;
import com.ztx.springcloud.entities.Payment;
import com.ztx.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ThreadUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

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
    @HystrixCommand(fallbackMethod = "getPaymentById_TimeoutHandler",commandKey = "userGetKey")
    @GetMapping(value = "getPaymentById/get/{id}")
    public CommentResult<Payment> getPaymentById(@PathVariable(name = "id") Long id) throws InterruptedException {
        log.info("结果：{}",id);
        TimeUnit.SECONDS.sleep(3);
        log.info("定时走完了");
        return new CommentResult<Payment>(200, port+":成功", paymentService.getPaymentById(id));
    }
    public CommentResult<Payment> getPaymentById_TimeoutHandler( Long id){
        return new CommentResult<Payment>(200, port+":降级啦");
    }
    @GetMapping(value = "getprot")
    public String getPort() {
        log.info("进来了");
        return port;
    }
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")//失败率，10次中有6次失败，启动断路器
    })
    @RequestMapping("payment/CircuitBreaker")
    public String paymentCircuitBreaker(int id ){
      return   paymentService.paymentCircuitBreaker(id);
    }
}
