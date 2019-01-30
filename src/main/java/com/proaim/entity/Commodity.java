package com.proaim.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 商品表
 *
 * @date 2019/1/29
 */
@Data
public class Commodity implements Serializable {
    private Long id; // 商品ID
    private Long brandId; // 品牌ID
    private Long categoryId; // 分类ID
    private String name; // 商品名称
    private String brandName; //品牌名称
    private String image; // 商品图片
    private String description; // 商品描述
    private BigDecimal price; // 商品价格
    private String detail; // 商品详情
    private Integer orderCommodity; // 排序
    private Timestamp createTime;
    private Timestamp updateTime;
    private Integer enabled; // 是否删除，默认为1

}
