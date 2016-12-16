package com.MarketplaceTunisia.security;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public void globalConfig(AuthenticationManagerBuilder auth, DataSource dataSource) throws Exception{
//		auth.inMemoryAuthentication().withUser("admin").password("123").roles("ADMIN");
//		auth.inMemoryAuthentication().withUser("hsan").password("123").roles("BUYER");
//		auth.inMemoryAuthentication().withUser("admin").password("123").roles("SELLER");
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		//.usersByUsernameQuery("select id_user as userId, pwd as password from user where mail = ?")
		//.authoritiesByUsernameQuery("select user_id_user as userId, roles_role as role from users_roles where user_id_user = ?")
		.usersByUsernameQuery("select user.name, user.pwd , 1 from user where user.name = ?")
		.authoritiesByUsernameQuery("select user.name, role.role from user join users_roles on user.id_user = users_roles.user_id_user join role on users_roles.roles_role = role.role where user.name = ?")
		.rolePrefix("ROLE_");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.authorizeRequests()
		.anyRequest()
		.authenticated()
		.and()
		.formLogin()
		//.loginPage("/login")
		.defaultSuccessUrl("/adress/all")
		.failureUrl("/login")
		.permitAll()
		.and()
		.logout()
		.invalidateHttpSession(true)
		.logoutUrl("/logout")
		.permitAll();
	}
}
