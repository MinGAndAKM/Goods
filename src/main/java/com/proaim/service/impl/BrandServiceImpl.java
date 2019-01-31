package com.proaim.service.impl;

import com.proaim.entity.Brand;
import com.proaim.mapper.BrandMapper;
import com.proaim.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @date 2019/1/31
 */
@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<Brand> listObjects() {
        return brandMapper.listBrand();
    }

    @Override
    public Brand getObjectById(Long id) {
        if (id != null) {
            return brandMapper.getBrandById(id);
        } else {
            return null;
        }
    }

    @Override
    public Brand getObjectByName(String name) {
        if (!StringUtils.isEmpty(name)) {
            return brandMapper.getBrandByName(name);
        } else {
            return null;
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveObject(Brand brand) {
        try {
            if (brand != null) {
                brandMapper.saveBrand(brand);
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
                    brandMapper.removeBrand(id);
                }
            }
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateObject(Brand brand) {
        try {
            if (brand != null) {
                brandMapper.updateBrand(brand);
            }
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }
    }
}
