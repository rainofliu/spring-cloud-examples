package com.segmentfault.spring.cloud.lesson10.user.service.client.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.Collections;

/**
 * User-Ribbon-Client HystrixCommand 基于编程的方式实现服务调用方的短路
 *
 * @author: ajin
 * @since 0.0.1
 */
public class UserRibbonClientHystrixCommand extends HystrixCommand<Collection> {

    private final RestTemplate restTemplate;
    /**
     * 要调用的服务的serviceId ，服务名
     */
    private final String serviceProviderAppName;

    public UserRibbonClientHystrixCommand(RestTemplate restTemplate, String serviceProviderAppName) {
        /**
         * 定义CommandGroupKey  和  超时时间
         * */
        super(HystrixCommandGroupKey.Factory.asKey("User-Ribbon-Client"),
                100);

        this.restTemplate = restTemplate;
        this.serviceProviderAppName = serviceProviderAppName;
    }

    /**
     * 主逻辑实现
     */
    @Override
    protected Collection run() throws Exception {
        return restTemplate.getForObject("http://" + serviceProviderAppName + "/user/list", Collection.class);

    }

    /**
     * Fall Back 实现  ：如果调用服务提供方超过 100 ms，那么我们就不去调用了，断开了
     */
    @Override
    protected Collection getFallback() {
        return Collections.emptyList();
    }
}
