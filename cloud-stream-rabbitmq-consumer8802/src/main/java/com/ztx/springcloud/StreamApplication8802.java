package com.ztx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class StreamApplication8802 {
    public static void main(String[] args) {
        SpringApplication.run(StreamApplication8802.class,args);
    }
}
