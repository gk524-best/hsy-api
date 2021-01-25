package com.hsy.common.api;

/*
|--------------------------------------------------------------------------
| API 状态码
|--------------------------------------------------------------------------
| 各个服务统一返回状态码： 成功状态码为0 错误状态码统一4位数 不同的模块指定不同的开头数字 -- 例如：全局错误 1001 登录失败
| 成功: 0
| 全局错误： 1开头
*/
public enum ApiCode implements ErrorCode {

    SUCCESS(true, 0, "操作成功"),
    UNKNOWN_ERROR(false, 1001, "未知错误"),
    NOT_PERMISSION(false, 1002, "没有权限"),
    LOGIN_ERROR(false, 1003, "用户名或密码错误"),
    VALIDATE_FAILED(false, 1004, "参数校验失败");


    private final Boolean status;

    private final Integer code;

    private final String message;

    ApiCode(Boolean status, Integer code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public Boolean getStatus() {
        return status;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
