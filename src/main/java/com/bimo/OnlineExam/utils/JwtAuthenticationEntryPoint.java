package com.bimo.OnlineExam.utils;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName: JwtAuthenticationEntryPoint
 * @Author: 13716
 * @Date: 2020/7/27 13:27
 * @Version: 1.0
 **/

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    /**
     * 没有通过认证的方法的返回处理
     * @param httpServletRequest   request
     * @param httpServletResponse  response
     * @param e                    错误信息
     * @throws IOException         IO 异常
     * @throws ServletException    Servlet 异常
     */
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "token 验证失败！");
    }
}
