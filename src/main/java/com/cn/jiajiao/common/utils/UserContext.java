package com.cn.jiajiao.common.utils;

public class UserContext {
    private static final ThreadLocal<String> userIdThreadLocal = new ThreadLocal<>();
    private static final ThreadLocal<String> phoneThreadLocal = new ThreadLocal<>();

    public static void setUserId(String userId) {
        userIdThreadLocal.set(userId);
    }

    public static String getUserId() {
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