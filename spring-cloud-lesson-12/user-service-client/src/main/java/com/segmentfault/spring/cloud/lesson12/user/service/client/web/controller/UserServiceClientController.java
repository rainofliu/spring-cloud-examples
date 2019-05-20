package com.segmentfault.spring.cloud.lesson12.user.service.client.web.controller;


import com.segmentfault.spring.cloud.lesson12.api.UserService;
import com.segmentfault.spring.cloud.lesson12.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * {@link UserService}客户端 {@link RestController}
 * <p>
 * <p>
 * 注意：官方建议 客户端和服务端不要同时实现Feign接口
 *
 * @author ajin
 */
@RestController
@Slf4j
public class UserServiceClientController implements UserService {

    @Autowired
    private UserService userService;

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    public UserServiceClientController(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/user/save/message")
    public boolean saveUserByMessage(@RequestBody User user) {

        log.info("comming ");

        ListenableFuture<SendResult<String, Object>> future =
                kafkaTemplate.send("sf-users", 0, user);
        log.debug("send");

        return future.isDone();

    }


    @Override
    public boolean addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @Override
    public List<User> findAll() {
        return userService.findAll();
    }
}
