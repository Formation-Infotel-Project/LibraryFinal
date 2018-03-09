package com.formation.infotel.controller.config;

import com.formation.infotel.services.impl.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MemberServiceImpl memberService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().hasAnyRole("ADMIN", "USER")
        .and()
            .authorizeRequests().antMatchers("/login**").permitAll()
        .and()
            .formLogin().loginPage("/login").loginProcessingUrl("/loginCheck").permitAll()
        .and()
            .logout().logoutSuccessUrl("/login").permitAll()
        .and()
            .csrf().disable();
    }
}
