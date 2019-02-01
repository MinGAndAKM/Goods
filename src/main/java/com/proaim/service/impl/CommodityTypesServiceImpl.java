package com.proaim.service.impl;

import com.proaim.entity.CommodityTypes;
import com.proaim.mapper.CommodityTypesMapper;
import com.proaim.service.CommodityTypesService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

/**
 * @date 2019/2/1
 */
@Service
public class CommodityTypesServiceImpl implements CommodityTypesService {
    @Autowired
    private CommodityTypesMapper commodityTypesMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByPrimaryKey(Object o) {
        try {
            return commodityTypesMapper.deleteByPrimaryKey((Short) o);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int delete(CommodityTypes commodityTypes) {
        return 0;
    }

    @Override
    public int insert(CommodityTypes commodityTypes) {
        return 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertSelective(CommodityTypes commodityTypes) {
        try {
            return commodityTypesMapper.insertSelective(commodityTypes);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public boolean existsWithPrimaryKey(Object o) {
        return false;
    }

    @Override
    public List<CommodityTypes> selectAll() {
        return commodityTypesMapper.selectByExample(null);
    }

    @Override
    public CommodityTypes selectByPrimaryKey(Object o) {
        return commodityTypesMapper.selectByPrimaryKey((Short) o);
    }

    @Override
    public int selectCount(CommodityTypes commodityTypes) {
        return 0;
    }

    @Override
    public List<CommodityTypes> select(CommodityTypes commodityTypes) {
        return null;
    }

    @Override
    public CommodityTypes selectOne(CommodityTypes commodityTypes) {
        return null;
    }

    @Override
    public int updateByPrimaryKey(CommodityTypes commodityTypes) {
        return 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateByPrimaryKeySelective(CommodityTypes commodityTypes) {
        try {
            return commodityTypesMapper.updateByPrimaryKeySelective(commodityTypes);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int deleteByExample(Object o) {
        return 0;
    }

    @Override
    public List<CommodityTypes> selectByExample(Object o) {
        return null;
    }

    @Override
    public int selectCountByExample(Object o) {
        return 0;
    }

    @Override
    public CommodityTypes selectOneByExample(Object o) {
        return null;
    }

    @Override
    public int updateByExample(CommodityTypes commodityTypes, Object o) {
        return 0;
    }

    @Override
    public int updateByExampleSelective(CommodityTypes commodityTypes, Object o) {
        return 0;
    }

    @Override
    public List<CommodityTypes> selectByExampleAndRowBounds(Object o, RowBounds rowBounds) {
        return null;
    }

    @Override
    public List<CommodityTypes> selectByRowBounds(CommodityTypes commodityTypes, RowBounds rowBounds) {
        return null;
    }

    @Override
    public List<CommodityTypes> listByParentId(Long parentId) {
        return commodityTypesMapper.listByParentId(parentId);
    }
}
