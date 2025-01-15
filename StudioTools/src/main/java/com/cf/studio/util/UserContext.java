package com.cf.studio.util;

public class UserContext {
    private static final ThreadLocal<String> userIdHolder = new ThreadLocal<>();

    // 设置用户ID
    public static void setUserId(String userId) {
        userIdHolder.set(userId);
    }

    // 获取用户ID
    public static String getUserId() {
        return userIdHolder.get();
    }

    // 清理用户ID
    public static void clear() {
        userIdHolder.remove();
    }
}
