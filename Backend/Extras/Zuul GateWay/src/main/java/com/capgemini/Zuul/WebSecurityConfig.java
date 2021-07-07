package com.capgemini.Zuul;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity public class WebSecurityConfig extends
		WebSecurityConfigurerAdapter {

	@Autowired UserDetailsServiceImpl userDetailsService;


	@Override protected void configure(AuthenticationManagerBuilder auth)throws
			Exception {
		auth.userDetailsService(userDetailsService);

	}

	@Override protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable().

				authorizeRequests() .antMatchers(HttpMethod.GET,"/userInfo/admin/validate").hasAnyRole("ADMIN")
				.antMatchers(HttpMethod.POST,"/userInfo/admin/post").hasAnyRole("ADMIN")
				.antMatchers("/userInfo/user/bookTicket").hasAnyRole("USER")
				.antMatchers(HttpMethod.GET,"/userInfo/user/signin").hasAnyRole("USER")
				.antMatchers(HttpMethod.DELETE,"/userInfo/admin/deletebyTrainName").hasAnyRole("ADMIN")
				.anyRequest().permitAll()
				.and().httpBasic();



	}
	@Bean public PasswordEncoder passwordEncoder() { return
			NoOpPasswordEncoder.getInstance(); }


}
