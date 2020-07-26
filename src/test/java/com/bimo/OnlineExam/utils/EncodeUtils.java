package com.bimo.OnlineExam.utils;

import com.bimo.OnlineExam.expection.EncodeException;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @ClassName: EncodeUtils
 * @Author: 13716
 * @Date: 2020/7/25 10:05
 * @Version: 1.0
 **/

public class EncodeUtils {
    @Test
    public void testEncode() throws EncodeException {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        for (int i = 0; i < 5; ++i) {
            // 每次生成的密码都不一样
            String encryptedPassword = passwordEncoder.encode("Passw0rd");
            System.out.println(encryptedPassword);
            System.out.println(passwordEncoder.matches("Passw0rd", encryptedPassword)); // true
            System.out.println(passwordEncoder.matches("Password", encryptedPassword)); // false
        }
    }
}
