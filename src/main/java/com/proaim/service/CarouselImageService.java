package com.proaim.service;

import com.proaim.entity.CarouselImage;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CarouselImageService extends Mapper<CarouselImage> {
    List<CarouselImage> selectByCarouselId(Long carouselId);
}
