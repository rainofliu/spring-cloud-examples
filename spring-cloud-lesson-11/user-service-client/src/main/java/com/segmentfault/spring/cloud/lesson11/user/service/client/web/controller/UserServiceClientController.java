package com.segmentfault.spring.cloud.lesson11.user.service.client.web.controller;

import com.segmentfault.spring.cloud.lesson11.api.UserService;
import com.segmentfault.spring.cloud.lesson11.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * {@link UserService}客户端 {@link RestController}
 *
 *
 * 注意：官方建议 客户端和服务端不要同时实现Feign接口
 *
 * @author ajin
 */
@RestController
public class UserServiceClientController implements UserService {

    @Autowired
    private UserService userService;

    @Override
    public boolean addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @Override
    public List<User> findAll() {
        return userService.findAll();
    }
}
