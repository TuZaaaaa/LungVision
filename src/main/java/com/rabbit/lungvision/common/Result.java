package com.rabbit.lungvision.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {

    private boolean success;
    private String msg;
    private T data;

    public static <T> Result<T> success() {
        Result<T> result = new Result<>();
        result.success = true;
        return result;
    }

    public static <T> Result<T> success(T object) {
        Result<T> result = new Result<>();
        result.data = object;
        result.success = true;
        return result;
    }

    public static <T> Result<T> error(String msg) {
        Result<T> result = new Result<>();
        result.msg = msg;
        result.success = false;
        return result;
    }

}
