package com.cn.jiajiao.common.utils;

public class UserContext {
    private static final ThreadLocal<Long> userIdThreadLocal = new ThreadLocal<>();
    private static final ThreadLocal<String> phoneThreadLocal = new ThreadLocal<>();

    public static void setUserId(Long userId) {
        userIdThreadLocal.set(userId);
    }

    public static Long getUserId() {
        return userIdThreadLocal.get();
    }

    public static void setPhone(String phone) {
        phoneThreadLocal.set(phone);
    }

    public static String getPhone() {
        return phoneThreadLocal.get();
    }

    public static void clear() {
        userIdThreadLocal.remove();
        phoneThreadLocal.remove();
    }
} 