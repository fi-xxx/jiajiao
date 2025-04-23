package com.cn.jiajiao.common.filter;

import cn.hutool.json.JSONUtil;
import com.cn.jiajiao.common.R;
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
            "/parents/login",
            "/parents/register",
            "/parents/refresh",
            "/error",
            "/parents"
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
            // token不为null 不为空
            if (!StringUtils.hasText(token)) {
                writeUnauthorized(httpResponse,"未登录或登录过期");
                return;
            }

            // 解析token
            Claims claims = JwtUtil.parseToken(token);
            
            // 获取用户信息
            String userId = claims.get("userId", String.class);
            String phone = claims.getSubject();
            
            // 保存到ThreadLocal
            UserContext.setUserId(userId);
            UserContext.setPhone(phone);
            // 继续执行过滤器链
            chain.doFilter(request, response);
        } catch (Exception e) {
            log.error("拦截到请求: {}" ,httpRequest.getRequestURI());
            log.error("token验证失败", e);
            writeUnauthorized(httpResponse,"未登录或登录过期");
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

    private void writeUnauthorized(HttpServletResponse response, String message) throws IOException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(JSONUtil.toJsonStr(R.error(401, message)));
    }
} 