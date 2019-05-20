package com.segmentfault.spring.cloud.lesson8.domain;

/**
 * @Auther: ajin
 * @Date: 2019/4/29 11:10
 */

public class User {

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
