package com.bimo.OnlineExam.utils;

import com.bimo.OnlineExam.expection.EncodeException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @ClassName: PasswordUtils
 * @Author: 13716
 * @Date: 2020/7/24 23:10
 * @Version: 1.0
 **/


public class PasswordUtils {
    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    public static String encode(String raw) {
        if (raw.length() < 6) {
            return null;
        }
        return passwordEncoder.encode(raw);
    }
}
