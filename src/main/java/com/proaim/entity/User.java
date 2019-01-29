package com.proaim.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户表
 *
 * @date 2019/1/24
 */
@Data
public class User implements Serializable {

    private Long id; //编号
    private String username; //用户名
    private String password; //密码

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
