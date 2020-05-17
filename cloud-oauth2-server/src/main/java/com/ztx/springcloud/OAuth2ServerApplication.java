package springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringCloudApplication
public class OAuth2ServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(OAuth2ServerApplication.class,args);
    }
}
