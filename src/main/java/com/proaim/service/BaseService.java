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
    List<T> listObjects();

    /**
     * 根据ID查询
     * param标签提供了对某个函数的参数的各项说明，包括参数名、参数数据类型、描述等。
     *
     * @param id ID
     * @return T
     */
    T getObjectById(Long id);

    /**
     * 根据名称查询
     *
     * @param name 名称
     * @return T
     */
    T getObjectByName(String name);

    /**
     * 添加
     *
     * @param t 实体类对象
     */
    void saveObject(T t);

    /**
     * 删除（批量）
     *
     * @param ids ID集
     */
    void removeObjects(Long... ids);

    /**
     * 修改
     *
     * @param t 实体类对象
     */
    void updateObject(T t);
}
