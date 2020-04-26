package com.ztx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudAlibabaConfigServer3377 {
    public static void main(String[] args) {
        SpringApplication.run(CloudAlibabaConfigServer3377.class,args);
    }
}
