package com.proaim.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * 轮播表
 *
 * @date 2019/1/29
 */
@Data
public class Carousel implements Serializable {
    private BigInteger id; // 轮播ID
    private Timestamp start_time;
    private Timestamp end_time;
    private Integer round_at_last;
    private Integer auto; // 是否自动播放
    private Integer order_commodity; // 按照0、1、2排序的先后顺序显示
    private Timestamp create_time;
    private Timestamp update_time;
    private Integer enabled; // 是否删除，默认为1

}
