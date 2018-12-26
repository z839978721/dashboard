package com.cloud.app.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.dao.user.UserMapper;

@Service(value = "userService")
public class UserService implements IUserService {

    @Autowired
    private UserMapper userDao;

    @Override
    public List findAllUser(){
        return null;
    }
    
}
