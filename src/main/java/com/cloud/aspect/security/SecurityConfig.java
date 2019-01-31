package com.cloud.aspect.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)  //  启用方法级别的权限认证
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private SecurityAuthenticationProvider provider;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/css/**", "/fonts/**", "/js/**").permitAll()//无需验证
		.anyRequest().authenticated()//每个请求都要求用户进行身份验证
		.and().formLogin().loginPage("/login").loginProcessingUrl("/user/login").successForwardUrl("/hello").failureUrl("/error").permitAll()//支持基于表单的身份验证
		.and().logout().permitAll().invalidateHttpSession(true)
		.and().csrf().disable();//
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(provider);
    }

}
