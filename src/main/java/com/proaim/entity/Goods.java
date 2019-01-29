package com.proaim.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 商品表
 *
 * @date 2019/1/24
 */
@Data
public class Goods implements Serializable {
    private Long id; //商品编号
    private String title; //商品标题
    private String price; //商品价格
    private String image; //商品图片
    private String brand; //商品品牌
}
