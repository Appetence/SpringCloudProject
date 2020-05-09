package com.ztx.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.ztx.springcloud.service.SentinalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
public class SentinalController {
    @Resource
    private SentinalService sentinalService;

    @RequestMapping("test")
    public String test() {
        sentinalService.getOrder();
        return "test;";
    }

    @RequestMapping("test2")
    public String test2() {
        sentinalService.getOrder();
        return "test2;";
    }

    @RequestMapping("test3")
    public String test3() throws InterruptedException {
        // sentinalService.getOrder();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("进来了：" + Thread.currentThread().getName());
        return "test3;";
    }

    @GetMapping("toHostKey")
    @SentinelResource(value = "toHostKey", blockHandler = "deal_toHostKey")//类似于hystrix的HystrixComment，value需要喝sentinal中热点配置中配置的资源相同
    public String toHostKey(@RequestParam(required = false,value = "p1") String p1,@RequestParam(required = false,value = "p2") String p2) {
        return "toHostKey";
    }
    public String deal_toHostKey(String p1, String p2, BlockException exeception){
        return "deal_deal_toHostKey_OO";
    }
}
