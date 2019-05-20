package com.segmentfault.spring.cloud.lesson11.web.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.segmentfault.spring.cloud.lesson11.api.UserService;
import com.segmentfault.spring.cloud.lesson11.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Random;


/**
 * 用户服务 提供方 Controller
 *
 * @Author: ajin
 * @Date: 2019/4/29 16:53
 */
@RestController
public class UserServiceProviderController implements UserService {

    @Autowired
    @Qualifier("inMemoryUserService")
    private UserService userService; // 实现Bean：InMemoryUserService


    /**
     * 模拟方法执行时间，仅供测试
     */
    private final static Random random = new Random();


    /**
     * 通过方法继承 ，URL映射 : /user/save
     * <p>
     * 这里只是为了方便不写@PostMapping注解才选择继承UserService接口
     */
    @Override
    public boolean addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    /**
     * 通过方法继承，URL映射 : /user/find/all
     */
    @HystrixCommand(
            commandProperties = { // command配置
                    // 设置超时时间为100 ms
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "100")
            },
            fallbackMethod = "fallBackForGetUsers"  // 设置 fallback 方法
    )
    @Override
    public List<User> findAll() {
        return userService.findAll();
    }


    /**
     * 获取所有用户列表
     */
    @HystrixCommand(
            commandProperties = { // command配置
                    // 设置超时时间为100 ms
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "100")
            },
            fallbackMethod = "fallBackForGetUsers"  // 设置 fallback 方法
    )
    @GetMapping("/user/list")
    public List<User> getUsers() throws InterruptedException {
        long executeTime = random.nextInt(200);

        // 通过休眠来模拟执行时间
        System.out.println("execute Time : " + executeTime + "ms");
        Thread.sleep(executeTime);

        return userService.findAll();
    }

    /**
     * {@link #getUsers()} 的 fallback方法
     *
     * @return 空集合
     */
    public List<User> fallBackForGetUsers() {
        return Collections.emptyList();
    }
}
