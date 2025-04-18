package com.cn.jiajiao.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class R<T> {
    private int code;
    private String message;
    private T data;


    public static <T> R<T> success(T data) {
        return new R<>(200, "操作成功", data);
    }

    public static <T> R<T> success(String message, T data) {
        return new R<>(200, message, data);
    }

    public static <T> R<T> error(String message) {
        return new R<>(400, message, null);
    }

    public static <T> R<T> error(int code,String message) {
        return new R<>(code, message, null);
    }

    public static <T> R<T> custom(int code, String message, T data) {
        return new R<>(code, message, data);
    }
}
