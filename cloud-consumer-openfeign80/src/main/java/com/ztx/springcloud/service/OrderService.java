package com.ztx.springcloud.service;

import com.ztx.springcloud.entities.CommentResult;
import com.ztx.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
@Component
public interface OrderService {

    @PostMapping(value = "create")
    public CommentResult<Payment> create(@RequestBody Payment payment);
    @GetMapping(value = "getPaymentById/get/{id}")
    public CommentResult<Payment> getPaymentById(@PathVariable(name = "id") Long id) ;
    @GetMapping(value = "getprot")
    public String getPort() ;
}
