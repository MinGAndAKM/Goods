package com.proaim.mapper;

import com.proaim.entity.CommodityImage;

import java.util.List;

public interface CommodityImageMapper {
    List<CommodityImage> listCommodityImage();

    CommodityImage getCommodityImageById(Long id);

    List<CommodityImage> getCommodityImageByCommodityId(Long commodityId);

    void saveCommodityImage(CommodityImage commodityImage);

    void removeCommodityImage(Long id);

    void removeCommodityImageByCommodityId(Long commodityId);

    void updateCommodityImage(CommodityImage commodityImage);
}
