package com.bimo.OnlineExam.utils.impl;

import com.bimo.OnlineExam.utils.TokenDetail;

/**
 * @ClassName: TokenDetailImpl
 * @Author: 13716
 * @Date: 2020/7/25 13:28
 * @Version: 1.0
 **/


public class TokenDetailImpl implements TokenDetail {
    private final String username;

    public TokenDetailImpl(String username) {
        this.username = username;
    }

    @Override
    public String getUsername() {
        return this.username;
    }
}
