package com.proaim.service;

import com.proaim.entity.Goods;
import com.proaim.entity.PageBean;

/**
 * @date 2019/1/24
 */
public interface GoodsService extends BaseService<Goods> {
    /**
     * 分页查询
     *
     * @param goods    查询条件
     * @param pageCode 当前页
     * @param pageSize 每页的记录数
     * @return PageBean对象
     */
    PageBean findByPage(Goods goods, Integer pageCode, Integer pageSize);
}
