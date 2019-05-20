package com.segmentfault.spring.cloud.lesson12;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * @Author: ajin
 * @Date: 2019/4/29 16:49
 */
@SpringBootApplication
@EnableHystrix
@EnableDiscoveryClient
@EnableBinding // 激活 Stream Binding 到 UserMessage
public class UserServiceProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceProviderApplication.class, args);
    }
}
