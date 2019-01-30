package com.proaim.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * 商品图片表
 *
 * @date 2019/1/29
 */
@Data
public class CommodityImage implements Serializable {
    private BigInteger id; // 图片ID
    private BigInteger commodity_id; // 商品ID
    private String url; // 商品图片
    private Timestamp create_time;
    private Timestamp update_time;
    private Integer enabled;// 是否删除，默认为1

}
