package com.bimo.OnlineExam.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: TokenUtils
 * @Author: 13716
 * @Date: 2020/7/25 11:57
 * @Version: 1.0
 **/

public class TokenUtils {
    private final String SECRET = "this_is_a_token_secret";
    private final Long expiration = Long.parseLong(String.valueOf(24 * 3600 * 1000));

    /**
     * 生成token，根据 tokenDetail，tokenDetail 可以通过 implement 进行扩充
     * @param tokenDetail 详见 TokenDetail.class
     * @return 返回 token 通过 generateToken(claim)
     */
    public String generateToken(TokenDetail tokenDetail) {
        Map<String, Object> claims = new HashMap<String, Object>();
        claims.put("sub", tokenDetail.getUsername());
        claims.put("created", this.generateCurrentDate());
        return this.generateToken(claims);
    }

    /**
     * 生成 token 的核心方法，是 generateToken 的重构方法
     * @param claims 一个包括基本信息的 claim Hashmap
     * @return 返回 token
     */
    private String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(this.generateExpirationDate())
                .signWith(SignatureAlgorithm.HS256, this.SECRET.getBytes(StandardCharsets.UTF_8))
                .compact();
    }

    /**
     * 生成 token 的过期日期
     * @return 日期
     */
    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + this.expiration);
    }

    /**
     * 返回系统现在的时间
     * @return 日期
     */
    private Date generateCurrentDate() {
        return new Date(System.currentTimeMillis());
    }

    /**
     * 从 token 中获取 username，依赖于 getClaimFromToken
     * @param token token
     * @return 返回 username
     */
    public String getUsernameFromToken(String token) {
        if (token.length() < 1) {
            return null;
        }
        String username;
        try {
            final Claims claim = this.getClaimsFromToken(token);
            username = claim.getSubject();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }

    /**
     * 从 token 中获取 claims
     * @param token token
     * @return 返回 claims
     */
    private Claims getClaimsFromToken(String token) {
        Claims claims;
        claims = Jwts.parser()
                .setSigningKey(this.SECRET.getBytes(StandardCharsets.UTF_8))
                .parseClaimsJws(token)
                .getBody();
        return claims;
    }

    /**
     * 从 httpRequest 中获取其中的 Token
     * @param request 请求
     * @return token
     */
    public String getTokenFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7, bearerToken.length());
        }
        return null;
    }

    /**
     * 核实 token 是否过期
     * @param token token
     * @return 是否过期的布尔值
     */
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET.getBytes(StandardCharsets.UTF_8)).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
