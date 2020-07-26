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
        });
        System.out.println(token);
    }

    @Test
    public void decodeToken() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJiaW1vIiwiY3JlYXRlZCI6MTU5NTY1OTIyMjI2M" +
                "iwiZXhwIjoxNTk1NzQ1NjIyfQ.sRocvR66B5xRGMOrYz2ckWP4x8Sad5Fu3tmgJKTZp8o";
        TokenUtils tokenUtils = new TokenUtils();
        System.out.println(tokenUtils.getUsernameFromToken(token));
    }
}
