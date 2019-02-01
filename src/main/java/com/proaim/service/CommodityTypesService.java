package com.proaim.service;

import com.proaim.entity.CommodityTypes;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CommodityTypesService extends Mapper<CommodityTypes> {
    List<CommodityTypes> listByParentId(Long parentId);
}
