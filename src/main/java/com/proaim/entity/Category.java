package com.proaim.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * 商品分类总表
 *
 * @date 2019/1/29
 */
@Data
public class Category implements Serializable {
    private BigInteger id; // 分类ID
    private String name; // 分类名称
    private Integer parent_id; // 父分类id
    private Timestamp create_time;
    private Timestamp update_time;
    private Integer enabled; // 是否删除，默认为1

}
