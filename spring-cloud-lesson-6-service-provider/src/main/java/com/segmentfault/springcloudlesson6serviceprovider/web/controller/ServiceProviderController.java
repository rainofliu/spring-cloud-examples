package com.segmentfault.springcloudlesson6serviceprovider.web.controller;

import com.segmentfault.springcloudlesson6serviceprovider.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 服务提供方的controller
 *
 * @Author: ajin
 * @Date: 2019/4/28 19:37
 */
@RestController
public class ServiceProviderController {

    private final Logger log = LoggerFactory.getLogger(ServiceProviderController.class);

    @Value("${server.port}")
    private Integer port;

    @PostMapping("/greeting")
    public String greeting(@RequestBody User user) {
        log.debug("Spring Cloud Service Provider port : {}", port);
        return "greeting :" + user+"  ,port :"+port;
    }

}
