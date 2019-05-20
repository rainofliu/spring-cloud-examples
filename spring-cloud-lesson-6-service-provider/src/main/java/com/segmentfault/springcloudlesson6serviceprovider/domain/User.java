package com.segmentfault.springcloudlesson6serviceprovider.domain;

import lombok.Data;

/**
 * 用户模型
 *
 * @Auther: ajin
 * @Date: 2019/4/28 20:08
 */
@Data
public class User {

    private Integer id;
    private String name;
}