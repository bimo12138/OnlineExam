package com.bimo.OnlineExam.service;

import com.bimo.OnlineExam.utils.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @ClassName: CustomUserDetailsService
 * @Author: 13716
 * @Date: 2020/7/27 11:52
 * @Version: 1.0
 **/

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return UserPrincipal.create(userService.getUserByUsername(s));
    }

    public UserDetails localUserById(Integer id) {
        return UserPrincipal.create(userService.getById(id));
    }
}
