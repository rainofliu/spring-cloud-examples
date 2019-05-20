package com.segmentfault.spring.cloud.lesson7.web.controller;

import com.segmentfault.spring.cloud.lesson7.api.UserService;
import com.segmentfault.spring.cloud.lesson7.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * 用户服务 提供方 Controller
 *
 * @Author: ajin
 * @Date: 2019/4/29 16:53
 */
@RestController
public class UserServiceProviderController {

    private final UserService userService;


    @Autowired
    public UserServiceProviderController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user/save")
    public boolean addUser(@RequestBody User user) {
        return userService.addUser(user);
    }
}
