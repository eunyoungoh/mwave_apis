package com.cjenm.mwave.apis.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Value("${spring.security.user.name}")
    private String username;

    @Value("${spring.security.user.password}")
    private String password;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
            .antMatchers("/js/**", "/css/**", "/assets/**", "/actuator/**", "/publishing/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
            .cors()
            .and()
            .csrf()
            .disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeRequests()
            .antMatchers("/apis/**")
            .permitAll();

        http.headers().frameOptions().disable();


        //
        //		 http.authorizeRequests()
        //		 	// Filter all actuator endpoints
        //		 	.antMatchers("/actuator/**")
        //		 		.hasRole("ACTRADMIN")
        //		 	// Anyone can login
        //		 .and()
        //		 	.authorizeRequests()
        //		 			.antMatchers("/login*")
        //		 				.permitAll()
        //		 					.anyRequest()
        //		 						.authenticated()
        //	     .and()
        //	          .formLogin()
        //	     .and()
        //	     	.authorizeRequests()
        //	     		.antMatchers("/**")
        //	     			.permitAll()
        //	     				.anyRequest();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


        auth.inMemoryAuthentication()
            .passwordEncoder(passwordEncoder)
            // Default User Name Password
            // this can be change to authentication of user on db
            .withUser(username).password(passwordEncoder.encode(password)).roles("ACTRADMIN");

    }
}
