package com.proaim.mapper;

import com.github.pagehelper.Page;
import com.proaim.entity.Goods;

import java.util.List;

/**
 * @date 2019/1/24
 */
public interface GoodsMapper {

    List<Goods> findAll();

    Page<Goods> findByPage(Goods goods);

    List<Goods> findById(Long id);

    void createGoods(Goods goods);

    void updateGoods(Goods goods);

    void deleteGoods(Long id);
}
