package com.proaim.service.impl;

import com.proaim.entity.CarouselImage;
import com.proaim.mapper.CarouselImageMapper;
import com.proaim.service.CarouselImageService;
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
public class CarouselImageServiceImpl implements CarouselImageService {
    @Autowired
    private CarouselImageMapper carouselImageMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByPrimaryKey(Object o) {
        try {
            return carouselImageMapper.deleteByPrimaryKey((Long) o);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int delete(CarouselImage carouselImage) {
        return 0;
    }

    @Override
    public int insert(CarouselImage carouselImage) {
        return 0;
    }

    @Override
    public int insertSelective(CarouselImage carouselImage) {
        return carouselImageMapper.insertSelective(carouselImage);
    }

    @Override
    public boolean existsWithPrimaryKey(Object o) {
        return false;
    }

    @Override
    public List<CarouselImage> selectAll() {
        return carouselImageMapper.selectByExample(null);
    }

    @Override
    public CarouselImage selectByPrimaryKey(Object o) {
        return carouselImageMapper.selectByPrimaryKey((Long) o);
    }

    @Override
    public int selectCount(CarouselImage carouselImage) {
        return 0;
    }

    @Override
    public List<CarouselImage> select(CarouselImage carouselImage) {
        return null;
    }

    @Override
    public CarouselImage selectOne(CarouselImage carouselImage) {
        return null;
    }

    @Override
    public int updateByPrimaryKey(CarouselImage carouselImage) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(CarouselImage carouselImage) {
        return 0;
    }

    @Override
    public int deleteByExample(Object o) {
        return 0;
    }

    @Override
    public List<CarouselImage> selectByExample(Object o) {
        return null;
    }

    @Override
    public int selectCountByExample(Object o) {
        return 0;
    }

    @Override
    public CarouselImage selectOneByExample(Object o) {
        return null;
    }

    @Override
    public int updateByExample(CarouselImage carouselImage, Object o) {
        return 0;
    }

    @Override
    public int updateByExampleSelective(CarouselImage carouselImage, Object o) {
        return 0;
    }

    @Override
    public List<CarouselImage> selectByExampleAndRowBounds(Object o, RowBounds rowBounds) {
        return null;
    }

    @Override
    public List<CarouselImage> selectByRowBounds(CarouselImage carouselImage, RowBounds rowBounds) {
        return null;
    }

    @Override
    public List<CarouselImage> selectByCarouselId(Long carouselId) {
        return carouselImageMapper.selectByCarouselId(carouselId);
    }
}
