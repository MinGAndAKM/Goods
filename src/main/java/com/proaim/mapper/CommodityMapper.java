package com.proaim.mapper;

import com.github.pagehelper.Page;
import com.proaim.entity.Commodity;

import java.util.List;

public interface CommodityMapper {
    List<Commodity> listCommodity();

    Page<Commodity> getByPage(Commodity commodity);

    Commodity getCommodityById(Long id);

    Commodity getCommodityByName(String name);

    void saveCommodity(Commodity commodity);

    void removeCommodity(Long id);

    void updateCommodity(Commodity commodity);

}
