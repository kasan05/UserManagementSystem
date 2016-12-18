package com.cmanagement.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {

	@Autowired
	private CManagementUserDetailService userDetailService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("abc").password("123").roles("hasRole('ROLE_ADMIN')");
		auth.inMemoryAuthentication().withUser("tyu").password("123").roles("hasRole('ROLE_USER')");
		auth.userDetailsService(userDetailService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/list").access("hasRole('ROLE_ADMIN')").and().formLogin(). // login
																											// configuration
				loginPage("/login").loginProcessingUrl("/login").usernameParameter("username")
				.passwordParameter("password").defaultSuccessUrl("/home").failureForwardUrl("/failure").and().logout(). // logout
																														// configuration
				logoutUrl("/appLogout").logoutSuccessUrl("/customLogin.jsp").and().exceptionHandling()
				.accessDeniedPage("/failure");
	}
}
