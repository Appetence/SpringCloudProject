package com.ztx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringCloudApplication
@RefreshScope//bush配置
public class GetWay9527Application {
    public static void main(String[] args) {
        SpringApplication.run(GetWay9527Application.class,args);
    }
}
