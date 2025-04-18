package com.cn.jiajiao.common.filter;

import com.cn.jiajiao.common.exception.UnauthorizedException;
import com.cn.jiajiao.common.utils.JwtUtil;
import com.cn.jiajiao.common.utils.UserContext;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Component
public class JwtAuthenticationFilter implements Filter {

    private static final List<String> EXCLUDE_PATHS = Arrays.asList(
            "/api/auth/login",
            "/api/auth/register",
            "/error"
    );

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // 获取请求路径
        String path = httpRequest.getRequestURI();
        
        // 检查是否是排除路径
        if (isExcludedPath(path)) {
            chain.doFilter(request, response);
            return;
        }

        try {
            // 获取token
            String token = getTokenFromRequest(httpRequest);
            if (!StringUtils.hasText(token)) {
                throw new UnauthorizedException("未登录或token已过期");
            }

            // 解析token
            Claims claims = JwtUtil.parseToken(token);
            
            // 获取用户信息
            Long userId = claims.get("userId", Long.class);
            String phone = claims.getSubject();
            
            // 保存到ThreadLocal
            UserContext.setUserId(userId);
            UserContext.setPhone(phone);
            
            // 继续执行过滤器链
            chain.doFilter(request, response);
        } catch (Exception e) {
            log.error("token验证失败", e);
            throw new UnauthorizedException("未登录或token已过期");
        } finally {
            // 清除ThreadLocal中的数据
            UserContext.clear();
        }
    }

    private String getTokenFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    private boolean isExcludedPath(String path) {
        return EXCLUDE_PATHS.stream().anyMatch(path::startsWith);
    }

    @Override
    public void init(FilterConfig filterConfig) {
        // 初始化方法
    }

    @Override
    public void destroy() {
        // 销毁方法
    }
} 