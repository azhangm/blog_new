package com.nuc.zmblog.exception;

/**
 * 异常枚举
 *
 * @author 74282
 * @date 2022/09/27
 */
public enum ExceptionEnum {
    USERNAME_ISEMPTY(10001,"用户名不能为空")
    ,PASSWORD_ISEMPTYE(10002,"密码不能为空")
    ,USERNAMEORPASSWORD_WRONG(10003,"用户名或密码错误");







    private Integer code;
    private String message;

     ExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
