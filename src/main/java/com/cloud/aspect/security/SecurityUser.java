package com.cloud.aspect.security;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cloud.model.user.User;
import com.cloud.model.user.UserEnum;

public class SecurityUser implements Serializable, UserDetails {
	
	/**
	 * 认证用户
	 */
	private static final long serialVersionUID = 2549852338883670312L;
	// 用户
	private User user;
	// 角色
	private Collection<? extends GrantedAuthority> grantedAuthority;

	public SecurityUser(User user, Collection<? extends GrantedAuthority> grantedAuthority) {
		super();
		this.user = user;
		this.grantedAuthority = grantedAuthority;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return grantedAuthority;
	}
	
	@Override
	public String getUsername() {
		return this.user.getUsername();
	}

	@Override
	public String getPassword() {
		return this.user.getPassword();
	}

	// 过期
	@Override
	public boolean isAccountNonExpired() {
		return this.user.getStatus().equals(UserEnum.ACCOUNTNONEXPIRED.getValue());
	}

	// 锁定
	@Override
	public boolean isAccountNonLocked() {
		return this.user.getStatus().equals(UserEnum.ACCOUNTNONLOCKED.getValue());
	}

	// 凭证（密码）过期
	@Override
	public boolean isCredentialsNonExpired() {
		return this.user.getStatus().equals(UserEnum.CREDENTIALSNONEXPIRED.getValue());
	}

	// 禁用
	@Override
	public boolean isEnabled() {
		return this.user.getStatus().equals(UserEnum.ENABLED.getValue());
	}
	
    
}