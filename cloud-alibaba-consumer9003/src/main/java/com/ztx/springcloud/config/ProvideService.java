package com.ztx.springcloud.config;

import com.ztx.springcloud.entities.CommentResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "cloud-alibaba-provider-service")
@Component
public interface ProvideService {
    @RequestMapping("getPort")
    public CommentResult<String> getPort() ;
}
