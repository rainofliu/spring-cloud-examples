package com.segmentfault.spring.cloud.lesson12.service;

import com.segmentfault.spring.cloud.lesson12.api.UserService;
import com.segmentfault.spring.cloud.lesson12.domain.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ajin
 * @date 2019/4/29 19:14
 */
@Service("inMemoryUserService") // Bean的名称
public class InMemoryUserService implements UserService {

    private Map<Long, User> userMap = new ConcurrentHashMap<Long, User>();


    @Override
    public boolean addUser(User user) {

        return userMap.put(user.getId(), user) == null;
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(userMap.values());
    }
}
