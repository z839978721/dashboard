package com.cloud.dao.role;

import java.util.List;

import com.cloud.model.role.Role;

public interface RoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(String id);
    
    List<Role> findByUserId(String userId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}