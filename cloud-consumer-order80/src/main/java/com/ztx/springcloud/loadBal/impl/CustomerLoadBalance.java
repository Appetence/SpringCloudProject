package com.ztx.springcloud.loadBal.impl;

import com.ztx.springcloud.loadBal.LoadBalance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
@Slf4j
@Component//自定义负载均衡
public class CustomerLoadBalance implements LoadBalance {
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    private  final  int getAndIncrement(){
        int current;
        int next;
        do{
            current = this.atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0:current+1;
        }while (!this.atomicInteger.compareAndSet(current,next));//成功，返回true,! 则结束循环
        log.info("******第几次请求访问****"+next);
        return  next;
    }
    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }

}
