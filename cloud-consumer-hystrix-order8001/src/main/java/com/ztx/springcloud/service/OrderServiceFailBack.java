package com.ztx.springcloud.service;

import com.ztx.springcloud.entities.CommentResult;
import com.ztx.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceFailBack implements OrderService {
    @Override
    public CommentResult<Payment> create(Payment payment) {
        return new CommentResult<>(400,"OrderServiceFailBack _ fail back create");
    }

    @Override
    public CommentResult<Payment> getPaymentById(Long id) {
        return new CommentResult<>(400,"OrderServiceFailBack fail back getPaymentById");
    }

    @Override
    public String getPort() {
        return "OrderServiceFailBack fail back getPort";
    }
}
