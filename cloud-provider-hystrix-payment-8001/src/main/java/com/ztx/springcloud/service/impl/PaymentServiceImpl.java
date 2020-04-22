package com.ztx.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.ztx.springcloud.dao.PaymentMapper;
import com.ztx.springcloud.entities.Payment;
import com.ztx.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentMapper paymentMapper;

    @Override
    public int create(Payment payment) {
        return paymentMapper.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentMapper.getPaymentById(id);
    }

    @Override
    public String paymentCircuitBreaker(Integer id){
        if(id < 0){
            throw new RuntimeException("**********id不可以为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"流水号："+serialNumber;

    }
}
