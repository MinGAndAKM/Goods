package com.proaim.mapper;

import com.proaim.entity.User;

import java.util.List;

/**
 * @date 2019/1/24
 */
public interface UserMapper {

    List<User> listUser();

    User getUserById(Long id);

    User getUserByName(String name);

    void saveUser(User user);

    void removeUser(Long id);

    void updateUser(User user);
}
