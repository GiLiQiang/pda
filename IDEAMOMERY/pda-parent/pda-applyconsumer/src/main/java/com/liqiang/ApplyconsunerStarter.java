package com.liqiang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ApplyconsunerStarter {
    public static void main(String[] args) {
        SpringApplication.run(ApplyconsunerStarter.class,args);
    }
}
