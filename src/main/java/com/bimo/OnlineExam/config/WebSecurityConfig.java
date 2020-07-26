package com.bimo.OnlineExam.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

/**
 * @ClassName: WebSecurityConfig
 * @Author: 13716
 * @Date: 2020/7/25 12:02
 * @Version: 1.0
 **/

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                // 允许所有请求进入
                .anyRequest().permitAll()
                .and()
                // 禁用 CSRF 验证
                .csrf().disable()
                // 拒绝自带了 session 策略 方便使用token
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
}
