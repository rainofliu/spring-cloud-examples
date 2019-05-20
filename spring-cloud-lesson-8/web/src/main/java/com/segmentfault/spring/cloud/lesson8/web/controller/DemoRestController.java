package com.segmentfault.spring.cloud.lesson8.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.TimeoutException;

/**
 * 一个测试接口类
 *
 * @author: ajin
 */
@RestController
public class DemoRestController {

    /**
     * 模拟方法执行时间，仅供测试
     */
    private final static Random random = new Random();

    /**
     * 当方法执行时间超过100 ms，触发异常
     */
    @GetMapping("")
    @SuppressWarnings("all")
    public String index() throws Exception {

        long executeTime = random.nextInt(200);
        if (executeTime > 100) { // 执行时间超过100 ms
            throw new TimeoutException("Execution Time Out");
        }
        return "Hello ,World!";
    }
}
