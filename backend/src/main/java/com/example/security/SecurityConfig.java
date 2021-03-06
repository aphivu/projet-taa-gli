package com.example.security;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

/**
 *
 * Configuration of Authenticationa and authorization with Spring Security
 * Here we implemented a Basic authentication
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userService;

    @Autowired
    private AccessDeniedHandler handler;

    @Autowired
    private BasicAuthenticationEntryPoint entryPoint;

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(userService);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .cors()
                .and()
                .authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/**").hasAnyRole("USER","ADMIN")
                .and()
                .httpBasic().authenticationEntryPoint(entryPoint)
                .and()
                .formLogin().loginProcessingUrl("/login")
                .and()
                .exceptionHandling().accessDeniedHandler(handler)
                .and()
                .logout()
                    .invalidateHttpSession(true)
                    .logoutUrl("/logout");
    }



}

