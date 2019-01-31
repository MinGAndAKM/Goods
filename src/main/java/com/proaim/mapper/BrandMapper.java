package com.proaim.mapper;

import com.proaim.entity.Brand;

import java.util.List;

public interface BrandMapper {
    List<Brand> listBrand();

    Brand getBrandById(Long id);

    Brand getBrandByName(String name);

    void saveBrand(Brand brand);

    void removeBrand(Long id);

    void updateBrand(Brand brand);
}
