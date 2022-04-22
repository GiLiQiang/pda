package com.liqiang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient    //提供服务
@EnableFeignClients   //开启feign调用服务
@EnableCircuitBreaker
@ServletComponentScan(basePackages = "com.liqiang.filters")
public class ProviderStarter {
    public static void main(String[] args) {
        SpringApplication.run(ProviderStarter.class,args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){return new RestTemplate();}
}
