package com.proaim.mapper;

import com.proaim.entity.CommodityTypes;
import com.proaim.entity.CommodityTypesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommodityTypesMapper {
    long countByExample(CommodityTypesExample example);

    int deleteByExample(CommodityTypesExample example);

    int deleteByPrimaryKey(Short typeId);

    int insert(CommodityTypes record);

    int insertSelective(CommodityTypes record);

    List<CommodityTypes> selectByExample(CommodityTypesExample example);

    CommodityTypes selectByPrimaryKey(Short typeId);

    int updateByExampleSelective(@Param("record") CommodityTypes record, @Param("example") CommodityTypesExample example);

    int updateByExample(@Param("record") CommodityTypes record, @Param("example") CommodityTypesExample example);

    int updateByPrimaryKeySelective(CommodityTypes record);

    int updateByPrimaryKey(CommodityTypes record);

    List<CommodityTypes> listByParentId(Long parentId);
}