package com.cloud.aspect.security;

import com.cloud.dao.user.UserMapper;
import com.cloud.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class SecurityUserDetailsService implements UserDetailsService {

	@Autowired
    private UserMapper userDao;
	
	@Override
	public SecurityUser loadUserByUsername(String userame) throws UsernameNotFoundException {
		User user = userDao.selectByUserName(userame);
		if (user != null) {
			SecurityUser userInfo=new SecurityUser(userame, user.getPassword(), "ROLE_ADMIN", true,true,true, true);
			return userInfo;
		}
	    return null;
	}

}
