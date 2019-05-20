package com.segmentfault.spring.cloud.lesson12.zuul.proxy;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Zuul 引导类
 *
 * @author ajin
 */
@EnableZuulProxy
@SpringCloudApplication
public class ZuulProxyApplication {

    public static void main(String[] args) {

        SpringApplication.run(ZuulProxyApplication.class, args);
    }
}
