package com.cloud.app.user;

import com.cloud.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userDao;//这里可能会报错，但是并不会影响

    @Override
    public List findAllUser(){
        return  userDao.findAllUser();
    }
}

