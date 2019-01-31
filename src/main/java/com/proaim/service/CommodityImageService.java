package com.proaim.service;

import com.proaim.entity.CommodityImage;

import java.util.List;

/**
 * @date 2019/1/31
 */
public interface CommodityImageService extends BaseService<CommodityImage> {
    List<CommodityImage> getCommodityImageByCommodityId(Long commodityId);

    void removeCommodityImageByCommodityId(Long... ids);
}
