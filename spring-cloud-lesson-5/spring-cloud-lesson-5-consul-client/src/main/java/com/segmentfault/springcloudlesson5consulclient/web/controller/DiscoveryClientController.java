package com.segmentfault.springcloudlesson5consulclient.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

/**
 * {@link DiscoveryClient}
 *
 * @Author: ajin
 * @Date: 2019/4/28 16:37
 */
@RestController
public class DiscoveryClientController {

    private final DiscoveryClient discoveryClient;

    private final String applicationName;

    @Autowired
    public DiscoveryClientController(DiscoveryClient discoveryClient,
                                     @Value("${spring.application.name}") String applicationName) {
        this.discoveryClient = discoveryClient;
        this.applicationName = applicationName;
    }

    /**
     * 获取所有的服务名称
     *
     * @param []
     * @return java.util.List<java.lang.String>
     **/
    @GetMapping("/list/services")
    public List<String> listServices() {
        return discoveryClient.getServices();
    }

    /**
     * 获取所有服务对应的实例
     */
    @GetMapping("/list/service-instances")
    public List<ServiceInstance> listServiceInstances() {
        List<String> services = listServices();

        List<ServiceInstance> serviceInstances = new LinkedList<>();

        services.forEach(serviceName -> {
            serviceInstances.addAll(discoveryClient.getInstances(serviceName));
        });
        return serviceInstances;
    }

    /**
     * 获取当前服务的一个实例
     */
    @GetMapping("/current/service-instance")
    public ServiceInstance getServiceInstances() {
        return discoveryClient.getInstances(applicationName).get(0);
    }
}
