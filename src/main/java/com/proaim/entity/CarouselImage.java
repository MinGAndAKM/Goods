package com.proaim.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * 轮播图片表
 *
 * @date 2019/1/29
 */
@Data
public class CarouselImage implements Serializable {
    private BigInteger id;
    private BigInteger carousel_id;
    private String name; // 图片名称
    private Double width; // 宽度
    private Double height; // 高度
    private String format; // 格式，png，jpg，jpeg，gif
    private String url; // 图片的访问地址
    private Timestamp create_time;
    private Timestamp update_time;
    private Integer enabled; // 是否删除，默认为1

}
