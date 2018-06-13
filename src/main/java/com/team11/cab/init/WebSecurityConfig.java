package com.team11.cab.init;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Import(WebAppConfig.class)
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Value("select username,password,enabled from user where username=?")
	private String usersQuery;
	
	@Value("select u.username,a.authority from user u inner join authorities a on(u.username=a.username) where u.username=?")
	private String rolesQuery;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth
//			.inMemoryAuthentication()
//				.withUser("user").password("password").roles("USER")
//				.and()
//				.withUser("admin").password("password").roles("ADMIN");
		
		auth
			.jdbcAuthentication()
				.usersByUsernameQuery(usersQuery)
				.authoritiesByUsernameQuery(rolesQuery)
				.dataSource(dataSource)
				.passwordEncoder(passwordEncoder);
	}

	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/user/**").hasRole("USER")
				.antMatchers("/admin/**").hasRole("ADMIN")
				.antMatchers("/**").permitAll()
				.and()
			.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/home?loginSuccess")
				.permitAll()
				.and()
			.logout();
	}
}