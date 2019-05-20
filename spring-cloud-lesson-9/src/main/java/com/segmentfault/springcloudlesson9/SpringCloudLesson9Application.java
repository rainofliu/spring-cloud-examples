package com.segmentfault.springcloudlesson9;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;


/**
 * @author ajin
 */
@SpringBootApplication
@EnableCircuitBreaker
public class SpringCloudLesson9Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudLesson9Application.class, args);
    }

}
