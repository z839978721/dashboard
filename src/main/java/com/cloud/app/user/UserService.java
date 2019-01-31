package com.cloud.app.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.dao.user.UserMapper;
import com.cloud.model.user.User;

@Service(value = "userService")
public class UserService implements IUserService {

    @Autowired
    private UserMapper userDao;

    @Override
    public List findAllUser(){
        return null;
    }

	@Override
	public User selectByUserName(String userName) {
		return userDao.selectByUserName(userName);
	}
    
}
