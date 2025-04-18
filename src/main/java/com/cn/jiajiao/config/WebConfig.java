package com.cn.jiajiao.config;

import com.cn.jiajiao.common.filter.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final ServletContext servletContext;

    @Override
    public void configureServletHandling(org.springframework.web.servlet.config.annotation.ServletRegistrationBean<?> registration) {
        // 注册JWT过滤器
        FilterRegistration.Dynamic jwtFilter = servletContext.addFilter("jwtAuthenticationFilter", jwtAuthenticationFilter);
        jwtFilter.addMappingForUrlPatterns(null, false, "/*");
    }
} 