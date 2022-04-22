package com.liqiang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaStaterConf {
    public static void main(String[] args) {
        SpringApplication.run(EurekaStaterConf.class,args);
    }
}
