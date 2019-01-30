package com.proaim.service;

import com.proaim.entity.Commodity;
import com.proaim.entity.PageBean;

public interface CommodityService extends BaseService<Commodity> {
    /**
     * 分页查询
     *
     * @param commodity 查询条件
     * @param pageCode  当前页码
     * @param pageSize  每页显示记录数
     * @return PageBean 将当前页数及每页记录数返回
     */
    PageBean getByPageBean(Commodity commodity, Integer pageCode, Integer pageSize);
}
