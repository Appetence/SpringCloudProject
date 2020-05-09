package com.ztx.springcloud.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.ztx.springcloud.service.SentinalService;
import org.springframework.stereotype.Service;

@Service
public class SentinalServiceImpl implements SentinalService {
    @Override
    @SentinelResource("getorder")
    public String getOrder() {
        System.out.println("=======进来了");
        return "this orider";
    }
}
