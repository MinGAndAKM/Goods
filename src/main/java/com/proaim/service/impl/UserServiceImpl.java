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
    public User findByName(String name) {
        return userMapper.findByName(name);
    }

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public List<User> findById(Long id) {
        return userMapper.findById(id);
    }

    @Override
    public void create(User user) {
        userMapper.createUser(user);
    }

    @Override
    public void delete(Long... ids) {
        for (Long id : ids) {
            userMapper.deleteUser(id);
        }
    }

    @Override
    public void update(User user) {
        userMapper.updateUser(user);
    }
}
