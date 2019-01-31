package com.cloud.aspect.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
public class SecurityAuthenticationProvider implements AuthenticationProvider {

	@Autowired
    private UserDetailsService securityUserDetailsService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
        String userName = token.getName();// 这个获取表单输入中返回的用户名;
        String password = (String) token.getCredentials();// 这个是表单中输入的密码；
        // 这里构建来判断用户是否存在和密码是否正确
        UserDetails userDetails = securityUserDetailsService.loadUserByUsername(userName); // 这里调用我们的自己写的获取用户的方法；
        if (userDetails == null) {
              throw new BadCredentialsException("用户名不存在");
        }
        // //这里我们还要判断密码是否正确，实际应用中，我们的密码一般都会加密，以Md5加密为例
        // Md5PasswordEncoder md5PasswordEncoder=new Md5PasswordEncoder();
        // //这里第个参数，是salt
        // 就是加点盐的意思，这样的好处就是用户的密码如果都是123456，由于盐的不同，密码也是不一样的，就不用怕相同密码泄漏之后，不会批量被破解。
        // String encodePwd=md5PasswordEncoder.encodePassword(password, userName);
        // //这里判断密码正确与否
        // if(!userInfo.getPassword().equals(encodePwd))
        // {
        // throw new BadCredentialsException("密码不正确");
        // }
        // //这里还可以加一些其他信息的判断，比如用户账号已停用等判断，这里为了方便我接下去的判断，我就不用加密了。
        //
        //
        if (!userDetails.getPassword().equals(password)) {
        	throw new BadCredentialsException("密码不正确");
        	
        }else if (userDetails.isAccountNonExpired()) {
        	throw new AccountExpiredException("账号已过期");
        	
        }else if (userDetails.isAccountNonLocked()) {
            throw new LockedException("账号已被锁定");
            
        }else if (userDetails.isCredentialsNonExpired()) {
            throw new CredentialsExpiredException("凭证已过期");
            
        }else if (userDetails.isEnabled()){
            throw new DisabledException("用户已被禁用");
            
        }
        
        // 构建返回的用户登录成功的token
        return new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		//返回true后才会执行上面的authenticate方法,这步能确保authentication能正确转换类型
		return UsernamePasswordAuthenticationToken.class.equals(authentication);
	}

}
