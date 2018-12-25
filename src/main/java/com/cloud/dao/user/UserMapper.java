package com.cloud.dao.user;

import java.util.List;

import com.cloud.model.user.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List findAllUser();
    
    User findUserByName();
}