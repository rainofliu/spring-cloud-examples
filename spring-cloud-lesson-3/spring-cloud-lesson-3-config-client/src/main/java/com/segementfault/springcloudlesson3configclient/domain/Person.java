package com.segementfault.springcloudlesson3configclient.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 用户模型
 *
 * @Author: ajin
 * @Date: 2019/4/26 21:36
 */
@ConfigurationProperties(prefix = "sf.user")
@Component
public class Person {

    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
