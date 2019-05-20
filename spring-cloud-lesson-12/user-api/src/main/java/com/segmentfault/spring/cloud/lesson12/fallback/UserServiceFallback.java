package com.segmentfault.spring.cloud.lesson12.fallback;

import com.segmentfault.spring.cloud.lesson12.api.UserService;
import com.segmentfault.spring.cloud.lesson12.domain.User;

import java.util.Collections;
import java.util.List;

/**
 * {@link UserService} Fallback实现
 *
 * @author ajin
 */

public class UserServiceFallback implements UserService {

    @Override
    public boolean addUser(User user) {
        return false;
    }

    @Override
    public List<User> findAll() {
        return Collections.emptyList();
    }
}
