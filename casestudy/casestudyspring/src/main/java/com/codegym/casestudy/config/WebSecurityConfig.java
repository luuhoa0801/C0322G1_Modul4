//package com.codegym.casestudy.config;
//
//import com.codegym.casestudy.service.MyUserDetailService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
//import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private MyUserDetailService service;
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//        auth.userDetailsService(service).passwordEncoder(passwordEncoder());
//    }
//    @Override
//    protected void configure(HttpSecurity http) throws Exception{
//        http.csrf().disable()
//                .formLogin().defaultSuccessUrl("/").permitAll()
//                .and()
//
//                .authorizeRequests().antMatchers("/").permitAll()
//                .antMatchers("/employee/employee").hasAnyRole("USER")
//                .antMatchers("/**").hasAnyRole("ADMIN")
//                .anyRequest().authenticated();
//        http.authorizeRequests().and().rememberMe()
//                .tokenRepository(persistentTokenRepository()).
//                tokenValiditySeconds(24*60*60);
//    }
//    @Bean
//    public PersistentTokenRepository persistentTokenRepository(){
//        InMemoryTokenRepositoryImpl inMemoryTokenRepository = new InMemoryTokenRepositoryImpl();
//        return inMemoryTokenRepository;
//    }
//
//}
