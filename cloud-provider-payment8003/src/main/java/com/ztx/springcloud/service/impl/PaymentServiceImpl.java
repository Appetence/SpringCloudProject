package com.ztx.springcloud.service.impl;

import com.ztx.springcloud.entities.Payment;
import com.ztx.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;
import com.ztx.springcloud.dao.PaymentMapper;

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
}
