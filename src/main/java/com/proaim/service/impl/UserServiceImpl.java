package com.proaim.service.impl;

import com.proaim.entity.User;
import com.proaim.mapper.UserMapper;
import com.proaim.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @date 2019/1/24
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getObjectByName(String name) {
        return userMapper.getUserByName(name);
    }

    @Override
    public List<User> listObjects() {
        return userMapper.listUser();
    }

    @Override
    public User getObjectById(Long id) {
        return userMapper.getUserById(id);
    }

    @Override
    public void saveObject(User user) {
        userMapper.saveUser(user);
    }

    @Override
    public void removeObjects(Long... ids) {
        for (Long id : ids) {
            userMapper.removeUser(id);
        }
    }

    @Override
    public void updateObject(User user) {
        userMapper.updateUser(user);
    }
}
