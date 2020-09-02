package com.bimo.OnlineExam.config;

import com.bimo.OnlineExam.service.CustomUserDetailsService;
import com.bimo.OnlineExam.utils.JwtAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


/**
 * @ClassName: WebSecurityConfig
 * @Author: 13716
 * @Date: 2020/7/25 12:02
 * @Version: 1.0
 **/

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private CustomUserDetailsService customUserDetailsService;

    private JwtAuthenticationEntryPoint authenticationEntryPoint;

    @Autowired
    public void setCustomUserDetailsService(CustomUserDetailsService customUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
    }

    @Autowired
    public void setAuthenticationEntryPoint(JwtAuthenticationEntryPoint authenticationEntryPoint) {
        this.authenticationEntryPoint = authenticationEntryPoint;
    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(customUserDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors() // 跨域
                .and()
                .csrf().disable() // 禁用 CSRF 验证
                .exceptionHandling().authenticationEntryPoint(authenticationEntryPoint) //异常处理机制
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 禁用SESSION
                .and()
                .authorizeRequests()
                    .antMatchers("/login", "/exam/new", "/emailCheck").permitAll()      // 不需要授权的
                    .antMatchers("/exam**").hasAnyAuthority("UPLOADER")
                    .antMatchers(HttpMethod.POST, "/user").permitAll()  // 不需要授权的,指定POST
                    .anyRequest().authenticated();   // 需要授权的
        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
