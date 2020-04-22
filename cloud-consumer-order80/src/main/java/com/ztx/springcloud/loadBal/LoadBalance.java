package com.ztx.springcloud.loadBal;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

//自定义接口，实现获取所有服务的方法
public interface LoadBalance {
    ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
