package com.cn.jiajiao.service;

import com.cn.jiajiao.common.exception.UnauthorizedException;
import com.cn.jiajiao.common.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class TokenService {

    private final RedisTemplate<String, Object> redisTemplate;
    
    private static final String REFRESH_TOKEN_PREFIX = "refresh_token:";
    private static final long REFRESH_TOKEN_EXPIRE_DAYS = 7; // 刷新token有效期7天

    /**
     * 生成访问令牌和刷新令牌
     * @param userId 用户ID
     * @param username 用户名
     * @return 包含accessToken和refreshToken的对象
     */
    public TokenPair generateTokens(String userId, String username) {
        // 生成访问令牌
        String accessToken = JwtUtil.generateToken(userId, username);
        
        // 生成刷新令牌
        String refreshToken = JwtUtil.generateRefreshToken();
        
        // 将刷新令牌存储到Redis中
        String redisKey = REFRESH_TOKEN_PREFIX + refreshToken;
        redisTemplate.opsForValue().set(redisKey, userId, REFRESH_TOKEN_EXPIRE_DAYS, TimeUnit.DAYS);
        
        return new TokenPair(accessToken, refreshToken);
    }

    /**
     * 使用刷新令牌获取新的访问令牌
     * @param refreshToken 刷新令牌
     * @param phone 手机号
     * @return 新的访问令牌
     */
    public String refreshAccessToken(String refreshToken, String phone) {
        String redisKey = REFRESH_TOKEN_PREFIX + refreshToken;
        String userId = (String) redisTemplate.opsForValue().get(redisKey);
        
        if (userId == null) {
            throw new UnauthorizedException("刷新令牌无效或已过期");
        }
        
        // 生成新的访问令牌
        return JwtUtil.generateToken(userId, phone);
    }

    /**
     * 使刷新令牌失效
     * @param refreshToken 刷新令牌
     */
    public void invalidateRefreshToken(String refreshToken) {
        String redisKey = REFRESH_TOKEN_PREFIX + refreshToken;
        redisTemplate.delete(redisKey);
    }

    /**
     * 令牌对
     */
    public static class TokenPair {
        private final String accessToken;
        private final String refreshToken;

        public TokenPair(String accessToken, String refreshToken) {
            this.accessToken = accessToken;
            this.refreshToken = refreshToken;
        }

        public String getAccessToken() {
            return accessToken;
        }

        public String getRefreshToken() {
            return refreshToken;
        }
    }
} 