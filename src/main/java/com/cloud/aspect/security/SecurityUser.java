package com.cloud.aspect.security;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

public class SecurityUser implements Serializable, UserDetails {
	
	/**
	 * 认证用户
	 */
	private static final long serialVersionUID = 2549852338883670312L;
	private String username;
    private String password;
    private String role;
    //过期
    private boolean accountNonExpired;
    //锁定
    private boolean accountNonLocked;
    //凭证（密码）过期
    private boolean credentialsNonExpired;
    //禁用
    private boolean enabled;

	public SecurityUser(String username, String password, String role, boolean accountNonExpired, boolean accountNonLocked,
			boolean credentialsNonExpired, boolean enabled) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
		this.accountNonExpired = accountNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.credentialsNonExpired = credentialsNonExpired;
		this.enabled = enabled;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return AuthorityUtils.commaSeparatedStringToAuthorityList(role);
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}
	
    
}