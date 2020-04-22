package com.ztx.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.ztx.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);

    public String paymentCircuitBreaker(Integer id);
}
