package com.cloud.aspect.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.cloud.dao.role.RoleMapper;
import com.cloud.dao.user.UserMapper;
import com.cloud.model.role.Role;
import com.cloud.model.user.User;

@Component
public class SecurityUserDetailsService implements UserDetailsService {

	@Autowired
    private UserMapper userMapper;
	
	@Autowired
    private RoleMapper roleMapper;
	
	@Override
	public UserDetails loadUserByUsername(String userame) throws UsernameNotFoundException {
		User user = userMapper.selectByUserName(userame);
		if (user != null) {
			List<Role> roles = roleMapper.findByUserId(user.getId());
			Collection<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
			for (Role role : roles) {
				SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(role.getName());
				grantedAuthorities.add(simpleGrantedAuthority);
			}
			UserDetails userDetails=new SecurityUser(user, grantedAuthorities);
			return userDetails;
		}
	    return null;
	}

}
