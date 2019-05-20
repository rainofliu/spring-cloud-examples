package com.segmentfault.spring.cloud.lesson12.domain;

import java.io.Serializable;

/**
 * 用户模型
 *
 * @author ajin
 */

public class User implements Serializable {


    private static final long serialVersionUID = 4680299451960835627L;

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
