package com.ztx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringCloudApplication
@EnableEurekaClient
public class TimeServer6001 {
    public static void main(String[] args) {
        SpringApplication.run(TimeServer6001.class,args);
    }
}
