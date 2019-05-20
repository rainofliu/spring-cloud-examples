package com.segmentfault.spring.cloud.lesson10.user.service.client.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

/**
 * 自定义{@link com.netflix.loadbalancer.IRule}实现
 *
 * @Author: ajin
 * @Date: 2019/4/29 17:16
 */

public class MyRule extends AbstractLoadBalancerRule {

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {

    }

    @Override
    public Server choose(Object key) {


        ILoadBalancer loadBalancer = getLoadBalancer();

        // 获取所有可达服务器
        List<Server> reachableServers = loadBalancer.getReachableServers();

        if(reachableServers==null){
            return null;
        }
        // 每次访问最后服务器
        int serverNum = reachableServers.size();

        return reachableServers.get(serverNum-1);
    }
}
