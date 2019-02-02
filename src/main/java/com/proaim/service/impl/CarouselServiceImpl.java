package com.proaim.service.impl;

import com.proaim.entity.Carousel;
import com.proaim.entity.CarouselExample;
import com.proaim.mapper.CarouselMapper;
import com.proaim.service.CarouselService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

/**
 * @date 2019/2/2
 */
@Service
public class CarouselServiceImpl implements CarouselService {
    @Autowired
    private CarouselMapper carouselMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByPrimaryKey(Object o) {
        try {
            return carouselMapper.deleteByPrimaryKey((Long) o);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int delete(Carousel carousel) {
        return 0;
    }

    @Override
    public int insert(Carousel carousel) {
        return 0;
    }

    @Override
    public int insertSelective(Carousel carousel) {
        try {
            return carouselMapper.insertSelective(carousel);
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
    public List<Carousel> selectAll() {
        CarouselExample carouselExample = new CarouselExample();
        carouselExample.setOrderByClause("`order_commodity` ASC,id ASC");
        // 查询结果优先按照字段1排序，若Number相同，则按id排序
        return carouselMapper.selectByExample(carouselExample);
    }

    @Override
    public Carousel selectByPrimaryKey(Object o) {
        return carouselMapper.selectByPrimaryKey((Long) o);
    }

    @Override
    public int selectCount(Carousel carousel) {
        return 0;
    }

    @Override
    public List<Carousel> select(Carousel carousel) {
        return null;
    }

    @Override
    public Carousel selectOne(Carousel carousel) {
        return null;
    }

    @Override
    public int updateByPrimaryKey(Carousel carousel) {
        return 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateByPrimaryKeySelective(Carousel carousel) {
        try {
            return carouselMapper.updateByPrimaryKeySelective(carousel);
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
    public List<Carousel> selectByExample(Object o) {
        return null;
    }

    @Override
    public int selectCountByExample(Object o) {
        return 0;
    }

    @Override
    public Carousel selectOneByExample(Object o) {
        return null;
    }

    @Override
    public int updateByExample(Carousel carousel, Object o) {
        return 0;
    }

    @Override
    public int updateByExampleSelective(Carousel carousel, Object o) {
        return 0;
    }

    @Override
    public List<Carousel> selectByExampleAndRowBounds(Object o, RowBounds rowBounds) {
        return null;
    }

    @Override
    public List<Carousel> selectByRowBounds(Carousel carousel, RowBounds rowBounds) {
        return null;
    }
}
