package com.segmentfault.spring.cloud.lesson12.api;

import com.segmentfault.spring.cloud.lesson12.domain.User;
import com.segmentfault.spring.cloud.lesson12.fallback.UserServiceFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * 用户服务
 *
 * @author ajin
 * @date 2019/4/29 19:11
 */
// 声明Feign客户端
@FeignClient(name = "${user.service.name}", fallback = UserServiceFallback.class)  // 利用占位符避免未来整合时硬编码
public interface UserService {


    /**
     * 保存用户
     *
     * @param user
     * @return boolean
     **/
    @PostMapping("/user/save")
    boolean addUser(User user);


    /**
     * 查询所有的用户列表
     *
     * @param
     * @return not-null
     **/
    @GetMapping("/user/find/all")
    List<User> findAll();


}
