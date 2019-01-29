package com.proaim.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @date 2019/1/24
 */
@Data
public class PageBean implements Serializable {

    //当前页
    private long total;
    //当前页记录
    private List rows;

    public PageBean(long total, List rows) {
        this.total = total;
        this.rows = rows;
    }
}
