package com.ztx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class StreamApplication8803 {
    public static void main(String[] args) {
        SpringApplication.run(StreamApplication8803.class,args);
    }
}
