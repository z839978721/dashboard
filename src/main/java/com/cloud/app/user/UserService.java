package com.cloud.app.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.dao.user.UserMapper;

@Service(value = "userService")
public class UserService implements IUserService {

    @Autowired
    private UserMapper userDao;//这里可能会报错，但是并不会影响

    @Override
    public List findAllUser(){
        return  userDao.findAllUser();
    }
    
}

