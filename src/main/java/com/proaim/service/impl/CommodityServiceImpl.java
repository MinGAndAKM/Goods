package com.proaim.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.proaim.entity.Commodity;
import com.proaim.entity.PageBean;
import com.proaim.mapper.CommodityMapper;
import com.proaim.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @date 2019/1/30
 */
@Service
public class CommodityServiceImpl implements CommodityService {
    @Autowired
    private CommodityMapper commodityMapper;

    /**
     * 分页查询
     *
     * @param commodity 查询条件
     * @param pageCode  当前页码
     * @param pageSize  每页显示记录数
     * @return PageBean 将当前页数及每页记录数返回
     */
    @Override
    public PageBean getByPageBean(Commodity commodity, Integer pageCode, Integer pageSize) {
        // 使用MyBatis插件
        PageHelper.startPage(pageCode, pageSize);
        // 调用分页查询方法，其实就是查询所有数据，MyBatis自动帮我们进行分页计算
        Page<Commodity> page = commodityMapper.getByPage(commodity);
        return new PageBean(page.getTotal(), page.getResult());
    }

    @Override
    public List<Commodity> listObjects() {
        return commodityMapper.listCommodity();
    }

    @Override
    public Commodity getObjectById(Long id) {
        return commodityMapper.getCommodityById(id);
    }

    @Override
    public Commodity getObjectByName(String name) {
        return commodityMapper.getCommodityByName(name);
    }

    @Override
    public void saveObject(Commodity commodity) {
        commodityMapper.saveCommodity(commodity);
    }

    @Override
    public void removeObjects(Long... ids) {
        for (Long id : ids) {
            commodityMapper.removeCommodity(id);
        }
    }

    @Override
    public void updateObject(Commodity commodity) {
        commodityMapper.updateCommodity(commodity);
    }
}
