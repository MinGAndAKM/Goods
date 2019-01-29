package com.proaim.service;

import java.util.List;

/**
 * 通用的Service层接口
 *
 * @date 2019/1/24
 */
public interface BaseService<T> {

    /**
     * 查询所有
     *
     * @return List<T>
     */
    List<T> findAll();

    /**
     * 根据ID查询
     * param标签提供了对某个函数的参数的各项说明，包括参数名、参数数据类型、描述等。
     *
     * @param id
     * @return T
     */
    List<T> findById(Long id);

    /**
     * 添加
     *
     * @param t
     */
    void create(T t);

    /**
     * 删除（批量）
     *
     * @param ids
     */
    void delete(Long... ids);

    /**
     * 修改
     *
     * @param t
     */
    void update(T t);
}
