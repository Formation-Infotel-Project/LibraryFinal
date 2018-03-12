package com.formation.infotel.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("julien.colleter@infotel.com")
            .password("motdepass")
            .roles("ADMIN");
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().permitAll()
        .and()
            .authorizeRequests().antMatchers("/login**").permitAll()
        .and()
            .formLogin().loginPage("/login").loginProcessingUrl("/loginCheck")
            .usernameParameter("userid")
            .passwordParameter("passwd")
            .successHandler((req, res, auth)->{
                    for(GrantedAuthority authority : auth.getAuthorities()){
                        System.out.println(authority.getAuthority());
                    }
                    System.out.println(auth.getName());
                    res.sendRedirect("index");
                })
            .failureHandler((req, res, exp)->{
                    String errMsg="";
                    if(exp.getClass().isAssignableFrom(BadCredentialsException.class)){
                        errMsg="Invalid username or password";
                    }else{
                        errMsg="Unknow error - "+exp.getMessage();
                    }
                    req.getSession().setAttribute("message", errMsg);
                    res.sendRedirect("login");
                })
            .permitAll()
        .and()
            .logout()
            .logoutUrl("/logout")
            .logoutSuccessHandler((req, res, auth)->{
                req.getSession().setAttribute("message", "You are logged out successfully");
                res.sendRedirect("login");
            }).permitAll()
        .and()
            .csrf().disable();
    }
}