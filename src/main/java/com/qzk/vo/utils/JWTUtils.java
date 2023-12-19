package com.qzk.vo.utils;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Slf4j
public class JWTUtils {
    private static final String key = "abc1234";    // 签名时使用的secret
    public static String getToken(Map<String, Object> claims) {
        // JWT的签发时间
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        // 指定签名的时候使用的签名算法
        SignatureAlgorithm signatureAlgotithm = SignatureAlgorithm.HS256;
        long expMillis = nowMillis + 604800000L;        // 默认设置7天过期
        Date expirationDate = new Date(expMillis);
        String token = Jwts.builder()               // 创建jwt builder
                .setClaims(claims)                      // 必须放最前面，不然后面设置的东西都会没有：如setExpiration会没有时间
                .setId(UUID.randomUUID().toString())     // jwt唯一标识
                .setIssuedAt(now)                                    // 签发时间
                .setExpiration(expirationDate)                 // 过期时间
                .signWith(signatureAlgotithm, key)          // 设置签名实用的签名算法和使用的密钥
                .compact();
        return token;
    }

    public static Claims JWTparse(String tokenAll) throws Exception {
        String msg = null;
        String token = tokenAll.replace("Bearer ", "");
        token = token.substring(1, token.length() - 1);
        try{
            Claims claims = Jwts.parser()
                    .setAllowedClockSkewSeconds(604800) // 允许7天的偏移
                    .setSigningKey(key)                         // 设置签名密钥
                    .parseClaimsJws(token).getBody(); // 设置需要解析的JWT
            return claims;
        }catch (SignatureException se) {
            msg = "密钥错误";
            log.error(msg, se);
            throw new RuntimeException(msg);
        }catch (MalformedJwtException me) {
            msg = "密钥算法或者密钥转换错误";
            log.error(msg, me);
            throw new RuntimeException(msg);
        }catch (MissingClaimException mce) {
            msg = "密钥缺少校验数据";
            log.error(msg, mce);
            throw new RuntimeException(msg);

        }catch (ExpiredJwtException mce) {
            msg = "密钥已过期";
            log.error(msg, mce);
            throw new RuntimeException(msg);

        }catch (JwtException jwte) {
            msg = "密钥解析错误";
            log.error(msg, jwte);
            throw new RuntimeException(msg);
        }
    }
}
