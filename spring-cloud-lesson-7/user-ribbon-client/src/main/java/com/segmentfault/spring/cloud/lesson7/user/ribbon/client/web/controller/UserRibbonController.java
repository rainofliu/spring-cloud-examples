package com.segmentfault.spring.cloud.lesson7.user.ribbon.client.web.controller;

import com.segmentfault.spring.cloud.lesson7.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * 用户 Ribbon Controller
 *
 * @Author: ajin
 * @Date: 2019/4/29 11:34
 */
@RestController
public class UserRibbonController {


    /**
     * 要调用的服务的serviceId ，服务名
     */
    @Value("${service.provider.app.name}")
    private String serviceProviderAppName;

    /**
     * 负载均衡器客户端
     */
    private final LoadBalancerClient loadBalancerClient;

    @Autowired
    public UserRibbonController(LoadBalancerClient loadBalancerClient) {
        this.loadBalancerClient = loadBalancerClient;
    }

    @GetMapping("")
    public String index() throws IOException {

        User user = new User();
        user.setId(1L);
        user.setName("ajin");

        // 选择指定的 serviceId对应的一台服务实例，也就是一个ip+port+"......"
        ServiceInstance serviceInstance = loadBalancerClient.choose(serviceProviderAppName);

        // 执行服务

        return loadBalancerClient.execute(serviceProviderAppName, serviceInstance, instance -> {

            // 服务器实例，获取 主机名（IP) 和端口
            String host = instance.getHost();
            int port = instance.getPort();

            // 拼接请求url
            String url = "http://" + host + ":" + port + "/user/save";
            RestTemplate restTemplate = new RestTemplate();

            return restTemplate.postForObject(url, user, String.class);
        });



    }

}
