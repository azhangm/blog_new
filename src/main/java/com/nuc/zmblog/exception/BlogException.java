package com.nuc.zmblog.exception;

/**
 * 博客例外
 *
 * @author 74282
 * @date 2022/09/27
 */
public class BlogException extends RuntimeException {
    private final Integer code;
    private final String message;

    public BlogException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public BlogException(ExceptionEnum e) {
        this(e.getCode(), e.getMessage());
    }

    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
