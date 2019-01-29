package com.proaim.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.proaim.entity.Goods;
import com.proaim.entity.PageBean;
import com.proaim.mapper.GoodsMapper;
import com.proaim.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @date 2019/1/24
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    /**
     * 分页查询-条件查询方法
     *
     * @param goods    查询条件
     * @param pageCode 当前页
     * @param pageSize 每页的记录数
     * @return PageBean 将总页数及当前页数返回
     */
    @Override
    public PageBean findByPage(Goods goods, Integer pageCode, Integer pageSize) {
        // 使用MyBatis插件
        PageHelper.startPage(pageCode, pageSize);

        // 调用分页查询方法，其实就是查询所有数据，MyBatis自动帮我们进行分页计算
        Page<Goods> page = goodsMapper.findByPage(goods);
        return new PageBean(page.getTotal(), page.getResult());
    }

    @Override
    public List<Goods> findAll() {
        return goodsMapper.findAll();
    }

    @Override
    public List<Goods> findById(Long id) {
        return goodsMapper.findById(id);
    }

    @Override
    public void create(Goods goods) {
        goodsMapper.createGoods(goods);
    }

    @Override
    public void delete(Long... ids) {
        for (Long id : ids) {
            goodsMapper.deleteGoods(id);
        }
    }

    @Override
    public void update(Goods goods) {
        goodsMapper.updateGoods(goods);
    }
}
