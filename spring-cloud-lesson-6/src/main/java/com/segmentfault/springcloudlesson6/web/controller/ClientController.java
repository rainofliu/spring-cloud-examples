package com.segmentfault.springcloudlesson6.web.controller;

import com.segmentfault.springcloudlesson6.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: ajin
 * @Date: 2019/4/28 19:44
 */
@RestController
public class ClientController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service-provider.host}")
    private String serviceProviderHost;

    @Value("${service-provider.port}")
    private Integer serviceProviderPort;

    @Value("${service-provider.name}")
    private String serviceProviderName;

    @GetMapping("")
    public String index() {
//        return restTemplate.postForObject("http://" +
//                        serviceProviderHost + ":" +
//                        serviceProviderPort + "/greeting ",
//                new User(1, "ajin"),
//                String.class);
        return restTemplate.postForObject("http://" +
                        serviceProviderName + "/greeting",
                new User(2, "wwww"),
                String.class);

    }

}
