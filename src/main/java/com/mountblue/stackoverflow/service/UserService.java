package com.mountblue.stackoverflow.service;

import com.mountblue.stackoverflow.Entity.User;

public interface UserService {
    User findById(int id);
}
