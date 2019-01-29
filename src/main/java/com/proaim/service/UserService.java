package com.proaim.service;

import com.proaim.entity.User;

public interface UserService extends BaseService<User> {
    User findByName(String name);
}
