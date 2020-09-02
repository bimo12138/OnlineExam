package com.bimo.OnlineExam.utils;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    public static boolean match(String raw, String encodedPassword) {
        return passwordEncoder.matches(raw, encodedPassword);
    }
}
