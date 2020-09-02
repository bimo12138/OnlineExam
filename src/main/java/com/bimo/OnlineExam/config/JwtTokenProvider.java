package com.bimo.OnlineExam.config;

import org.springframework.stereotype.Component;

/**
 * @ClassName: JwtTokenProvider
 * @Author: 13716
 * @Date: 2020/7/27 22:07
 * @Version: 1.0
 **/

@Component
public class JwtTokenProvider {
    private final String SECRET = "this_is_a_token_secret";
    private final Long expiration = Long.parseLong(String.valueOf(24 * 3600 * 1000));

}
