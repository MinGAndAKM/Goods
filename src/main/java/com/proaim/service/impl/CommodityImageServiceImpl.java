package com.proaim.service.impl;

import com.proaim.entity.CommodityImage;
import com.proaim.mapper.CommodityImageMapper;
import com.proaim.service.CommodityImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

/**
 * @date 2019/1/31
 */
@Service
public class CommodityImageServiceImpl implements CommodityImageService {
    @Autowired
    private CommodityImageMapper commodityImageMapper;

    @Override
    public List<CommodityImage> getCommodityImageByCommodityId(Long commodityId) {
        if (commodityId != null) {
            return commodityImageMapper.getCommodityImageByCommodityId(commodityId);
        } else {
            return null;
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void removeCommodityImageByCommodityId(Long... ids) {
        try {
            if (ids != null) {
                for (Long id : ids) {
                    commodityImageMapper.removeCommodityImageByCommodityId(id);
                }
            }
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }
    }

    @Override
    public List<CommodityImage> listObjects() {
        return commodityImageMapper.listCommodityImage();
    }

    @Override
    public CommodityImage getObjectById(Long id) {
        if (id != null) {
            return commodityImageMapper.getCommodityImageById(id);
        } else {
            return null;
        }
    }

    @Override
    public CommodityImage getObjectByName(String name) {
        return null;
    }

    @Override
    /**
     * TODO!
     * @Transactional 加于private方法, 无效
     * @Transactional 加于未加入接口的public方法, 再通过普通接口方法调用, 无效
     * @Transactional 加于接口方法, 无论下面调用的是private或public方法, 都有效
     * @Transactional 加于接口方法后, 被本类普通接口方法直接调用, 无效
     * @Transactional 加于接口方法后, 被本类普通接口方法通过接口调用, 有效
     * @Transactional 加于接口方法后, 被它类的接口方法调用, 有效
     * @Transactional 加于接口方法后, 被它类的私有方法调用后, 有效
     * Transactional是否生效, 仅取决于是否加载于接口方法, 并且是否通过接口方法调用(而不是本类调用)。
     */
    @Transactional(rollbackFor = Exception.class)
    public void saveObject(CommodityImage commodityImage) {
        try {
            if (commodityImage != null) {
                commodityImageMapper.saveCommodityImage(commodityImage);
            }
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void removeObjects(Long... ids) {
        try {
            if (ids != null) {
                for (Long id : ids) {
                    commodityImageMapper.removeCommodityImage(id);
                }
            }
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateObject(CommodityImage commodityImage) {
        try {
            if (commodityImage != null) {
                commodityImageMapper.updateCommodityImage(commodityImage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
