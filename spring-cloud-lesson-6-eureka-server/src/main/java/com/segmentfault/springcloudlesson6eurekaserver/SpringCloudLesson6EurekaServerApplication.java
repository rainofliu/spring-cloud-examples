package com.segmentfault.springcloudlesson6eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringCloudLesson6EurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudLesson6EurekaServerApplication.class, args);
    }

}
