package com.bimo.OnlineExam.utils;

import org.junit.jupiter.api.Test;

/**
 * @ClassName: TokenTest
 * @Author: 13716
 * @Date: 2020/7/25 14:06
 * @Version: 1.0
 **/


public class TokenTest {
    @Test
    public void getToken() {
        TokenUtils tokenUtils = new TokenUtils();
        String token = tokenUtils.generateToken(new TokenDetail() {
            @Override
            public String getUsername() {
                return "bimo";
            }

            @Override
            public boolean isSuperuser() {
                return false;
            }

            @Override
            public boolean isUploader() {
                return false;
            }
        });
        System.out.println(token);
    }

    @Test
    public void decodeToken() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJiaW1vIiwiY3JlYXRlZCI6MTU5NTg5ODE5NTM1MCwiZXhwIjoxNTk1OTg0NTk1fQ.wZ08HOJFTP8WqytlnuCATiNt6C6QY6_4GmjvDsJR0_s";
        TokenUtils tokenUtils = new TokenUtils();
        System.out.println(tokenUtils.getUsernameFromToken(token));
        System.out.println(tokenUtils.validateToken(token));
    }
}
