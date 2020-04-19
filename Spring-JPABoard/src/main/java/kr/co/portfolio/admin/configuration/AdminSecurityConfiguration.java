package kr.co.portfolio.admin.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.extern.java.Log;


@Log
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
@Order(value = 1)
public class AdminSecurityConfiguration extends WebSecurityConfigurerAdapter{

	public AdminSecurityConfiguration() {
		//TODO Auto-generated method stub
		super();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		super.configure(http);
		log.info("Admin Spring Security Configuration");
		/** Admin Login Logic */
		/*
		http.antMatcher("/admin/**")
		.authorizeRequests()
		.antMatchers("/admin/users/login")
		.hasRole("ADMIN")
		.anyRequest()
		.authenticated()
		.and()
		.formLogin()
		.loginPage("/admin/users/login")
		.loginProcessingUrl("/admin/users/login")
		.usernameParameter("email")
		.passwordParameter("password")
		.defaultSuccessUrl("/admin")
		.permitAll(true)
		.and()
		.logout()
		.logoutUrl("/admin/users/logout")
		.logoutSuccessUrl("/")
		.invalidateHttpSession(true)
		.permitAll()
		.and()
		.sessionManagement()
		.maximumSessions(1)
		.expiredUrl("/")
		.maxSessionsPreventsLogin(false);
		*/
		/** User Login Logic */
		//http.userDetailsService(UserSerives);
		//super.configure(http);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
