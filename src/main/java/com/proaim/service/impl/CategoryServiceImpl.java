package com.proaim.service.impl;

import com.proaim.entity.Category;
import com.proaim.mapper.CategoryMapper;
import com.proaim.service.CategoryService;
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
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByPrimaryKey(Object o) {
        try {
            return categoryMapper.deleteByPrimaryKey((Long) o);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int delete(Category category) {
        return 0;
    }

    @Override
    public int insert(Category category) {
        return 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertSelective(Category category) {
        try {
            return categoryMapper.insertSelective(category);
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
    public List<Category> selectAll() {
        return categoryMapper.selectByExample(null);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Category selectByPrimaryKey(Object o) {
        return categoryMapper.selectByPrimaryKey((Long) o);
    }

    @Override
    public int selectCount(Category category) {
        return 0;
    }

    @Override
    public List<Category> select(Category category) {
        return null;
    }

    @Override
    public Category selectOne(Category category) {
        return null;
    }

    @Override
    public int updateByPrimaryKey(Category category) {
        return 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateByPrimaryKeySelective(Category category) {
        try {
            return categoryMapper.updateByPrimaryKeySelective(category);
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
    public List<Category> selectByExample(Object o) {
        return null;
    }

    @Override
    public int selectCountByExample(Object o) {
        return 0;
    }

    @Override
    public Category selectOneByExample(Object o) {
        return null;
    }

    @Override
    public int updateByExample(Category category, Object o) {
        return 0;
    }

    @Override
    public int updateByExampleSelective(Category category, Object o) {
        return 0;
    }

    @Override
    public List<Category> selectByExampleAndRowBounds(Object o, RowBounds rowBounds) {
        return null;
    }

    @Override
    public List<Category> selectByRowBounds(Category category, RowBounds rowBounds) {
        return null;
    }
}
