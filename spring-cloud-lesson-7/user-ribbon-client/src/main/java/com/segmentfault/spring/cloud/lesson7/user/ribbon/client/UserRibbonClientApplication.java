package com.segmentfault.spring.cloud.lesson7.user.ribbon.client;

import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.segmentfault.spring.cloud.lesson7.user.ribbon.client.ping.MyPing;
import com.segmentfault.spring.cloud.lesson7.user.ribbon.client.rule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * @Author: ajin
 * @Date: 2019/4/29 11:44
 */
@SpringBootApplication
// 指定目标应用名称，也就是我要通过Ribbon去调用哪个应用
@RibbonClient(name = "user-service-provider")
public class UserRibbonClientApplication {

    public static void main(String[] args) {

        SpringApplication.run(UserRibbonClientApplication.class, args);

    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /**
     * 将 {@link MyRule}暴露给{@link Bean}
     */
    @Bean
    public IRule iRule() {
        return new MyRule();
    }

    @Bean
    public IPing myPing() {
        return new MyPing();
    }
}
