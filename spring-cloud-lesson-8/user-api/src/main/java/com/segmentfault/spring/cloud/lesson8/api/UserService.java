package com.segmentfault.spring.cloud.lesson8.api;

import com.segmentfault.spring.cloud.lesson8.domain.User;

import java.util.List;

/**
 * 用户服务
 *
 * @Author: ajin
 * @Date: 2019/4/29 11:11
 */
public interface UserService {


    /**
     * 保存用户
     *
     * @param user
     * @return boolean
     **/
    boolean addUser(User user);


    /**
     * 查询所有的用户列表
     * @param
     * @return not-null
     **/
    List<User> findAll();



}
