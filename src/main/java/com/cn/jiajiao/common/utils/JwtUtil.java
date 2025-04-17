package com.cn.jiajiao.common.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

@Slf4j
@Component
public class JwtUtil {

    private static PrivateKey privateKey;
    private static PublicKey publicKey;

    static {
        try {
            // 加载私钥
            ClassPathResource privateKeyResource = new ClassPathResource("private_key.pem");
            try (InputStream privateKeyStream = privateKeyResource.getInputStream()) {
                String privateKeyContent = new String(privateKeyStream.readAllBytes())
                        .replace("-----BEGIN PRIVATE KEY-----", "")
                        .replace("-----END PRIVATE KEY-----", "")
                        .replaceAll("\\s", "");
                byte[] privateKeyBytes = Base64.getDecoder().decode(privateKeyContent);
                PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
                KeyFactory keyFactory = KeyFactory.getInstance("RSA");
                privateKey = keyFactory.generatePrivate(keySpec);
            }

            // 加载公钥
            ClassPathResource publicKeyResource = new ClassPathResource("public_key.pem");
            try (InputStream publicKeyStream = publicKeyResource.getInputStream()) {
                String publicKeyContent = new String(publicKeyStream.readAllBytes())
                        .replace("-----BEGIN PUBLIC KEY-----", "")
                        .replace("-----END PUBLIC KEY-----", "")
                        .replaceAll("\\s", "");
                byte[] publicKeyBytes = Base64.getDecoder().decode(publicKeyContent);
                X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKeyBytes);
                KeyFactory keyFactory = KeyFactory.getInstance("RSA");
                publicKey = keyFactory.generatePublic(keySpec);
            }
        } catch (Exception e) {
            log.error("加载密钥失败", e);
            throw new RuntimeException("加载密钥失败", e);
        }
    }

    /**
     * 生成JWT token
     * @param userId 用户ID
     * @param username 用户名
     * @return JWT token
     */
    public static String generateToken(Long userId, String username) {
        Date now = new Date();
        // 设置token过期时间为15分钟
        Date expiration = new Date(now.getTime() + 15 * 60 * 1000);

        return Jwts.builder()
                .setId(UUID.randomUUID().toString())
                .setSubject(username)
                .claim("userId", userId)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(privateKey, SignatureAlgorithm.RS256)
                .compact();
    }

    /**
     * 解析JWT token
     * @param token JWT token
     * @return Claims对象
     */
    public static Claims parseToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(publicKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * 验证JWT token是否有效
     * @param token JWT token
     * @return 是否有效
     */
    public static boolean validateToken(String token) {
        try {
            parseToken(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 生成Refresh Token
     * @return UUID格式的Refresh Token
     */
    public static String generateRefreshToken() {
        return UUID.randomUUID().toString();
    }
} 