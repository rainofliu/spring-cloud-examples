package com.segmentfault.springcloudlesson6.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户模型
 *
 * @Auther: ajin
 * @Date: 2019/4/28 20:08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer id;
    private String name;
}
