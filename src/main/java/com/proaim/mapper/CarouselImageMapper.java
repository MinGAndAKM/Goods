package com.proaim.mapper;

import com.proaim.entity.CarouselImage;
import com.proaim.entity.CarouselImageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CarouselImageMapper {
    long countByExample(CarouselImageExample example);

    int deleteByExample(CarouselImageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CarouselImage record);

    int insertSelective(CarouselImage record);

    List<CarouselImage> selectByExample(CarouselImageExample example);

    CarouselImage selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CarouselImage record, @Param("example") CarouselImageExample example);

    int updateByExample(@Param("record") CarouselImage record, @Param("example") CarouselImageExample example);

    int updateByPrimaryKeySelective(CarouselImage record);

    int updateByPrimaryKey(CarouselImage record);
}