package com.proaim.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * 商品类别表
 *
 * @date 2019/1/29
 */
@Data
public class CommodityTypes implements Serializable {
    private Integer type_id; // 分类ID
    private String type_name; // 分类名称
    private BigInteger parent_id; // 父分类id
}
