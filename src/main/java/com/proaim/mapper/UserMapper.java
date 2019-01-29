package com.proaim.mapper;

import com.proaim.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @date 2019/1/24
 */
public interface UserMapper {

    List<User> findAll();

    List<User> findById(Long id);

    User findByName(String name);

    void createUser(User user);

    void deleteUser(Long id);

    void updateUser(User user);
}
