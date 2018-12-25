package com.cloud.aspect.security;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class SecurityUserDetailsService implements UserDetailsService {

	@Override
	public SecurityUser loadUserByUsername(String userame) throws UsernameNotFoundException {
		if (userame.equals("admin")) {
			SecurityUser userInfo=new SecurityUser(userame, "123456", "ROLE_ADMIN", true,true,true, true);
			return userInfo;
		}
	    return null;
	}

}
