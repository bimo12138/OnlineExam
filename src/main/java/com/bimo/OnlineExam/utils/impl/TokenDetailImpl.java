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
    private final boolean isSuperuser;
    private final boolean isUploader;

    public TokenDetailImpl(String username, boolean isSuperuser, boolean isUploader) {
        this.username = username;
        this.isSuperuser = isSuperuser;
        this.isUploader = isUploader;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isSuperuser() {
        return this.isSuperuser;
    }

    @Override
    public boolean isUploader() {
        return this.isUploader;
    }
}
