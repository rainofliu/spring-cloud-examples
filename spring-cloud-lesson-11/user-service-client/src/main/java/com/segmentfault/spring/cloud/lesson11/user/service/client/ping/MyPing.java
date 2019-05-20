package com.segmentfault.spring.cloud.lesson11.user.service.client.ping;

import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.Server;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * 实现{@link IPing} : 检查对象 /health 是否正常状态码
 *
 * @Author: ajin
 * @Date: 2019/4/29 17:48
 */

public class MyPing implements IPing {

    @Override
    public boolean isAlive(Server server) {

        String host = server.getHost();
        int port = server.getPort();
        // /health point
        // 通过Spring 组件来实现URL 拼装
        UriComponentsBuilder builder = UriComponentsBuilder.newInstance();
        builder.scheme("http");
        builder.host(host);
        builder.port(port);
        builder.path("/health");
        URI uri = builder.build().toUri();

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity responseEntity =restTemplate.getForEntity(uri, String.class);
        System.out.println("----------------------------- "+responseEntity.getStatusCode());
        // 当状态码等于200时，返回true ，否则false
        return HttpStatus.OK.equals(responseEntity.getStatusCode());
    }
}
