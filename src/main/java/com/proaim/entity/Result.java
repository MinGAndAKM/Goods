package com.proaim.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @date 2019/1/24
 */
@Data
public class Result implements Serializable {

    //判断结果
    private boolean success;
    //返回信息
    private String message;

    public Result() {
    }

    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
