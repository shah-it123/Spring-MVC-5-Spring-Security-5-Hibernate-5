package com.boraji.tutorial.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private UserDetailsService userDetailsService;
  
  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  };
  
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
  }
  
  @Override
  protected void configure(HttpSecurity http) throws Exception {
//	  http.authorizeRequests().anyRequest().hasAnyRole("ADMIN", "BANKER","USER")
//    .and()
	  
	  http
          .csrf().disable()      
          .httpBasic()
          .and()
      .authorizeRequests()
      	  .antMatchers("/login**").permitAll()
          .antMatchers("/user1").hasAnyRole("USER","ADMIN")
          .antMatchers("/user2").hasAnyRole("BANKER","ADMIN")
          .antMatchers("/admin").hasRole("ADMIN")
          .anyRequest().authenticated()
          .and()
      .formLogin().loginPage("/login").loginProcessingUrl("/loginAction").permitAll();
//          .and()
//      .exceptionHandling().accessDeniedPage("/403");
  }
}