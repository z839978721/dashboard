package com.cloud.app.user;

import java.util.List;

import com.cloud.model.user.User;

public interface IUserService {

    List findAllUser();
    
    User selectByUserName(String userName);
    
}
