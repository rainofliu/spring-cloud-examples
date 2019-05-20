package com.segementfault.springcloudlesson3configclient.web.controller;

import com.segementfault.springcloudlesson3configclient.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: ajin
 * @Date: 2019/4/26 21:38
 */
@RestController
@EnableConfigurationProperties(Person.class)
public class PersonController {

    // 通过构造器注入
    private final Person person;


    @Autowired
    public PersonController(Person person) {
        this.person = person;
    }

    @GetMapping("/user")
    public Person getPerson() {
        return person;
    }
}
