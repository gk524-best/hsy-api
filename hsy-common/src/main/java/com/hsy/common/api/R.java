package com.hsy.common.api;

/**
 * @Description:
 * @Author: GK
 * @Date: Created in 2021/1/24 10:27
 */
public class R<T> {
    private Boolean status;
    private Integer code;
    private String message;
    private T data;

    private R() {

    }

    private R(Boolean status, Integer code, String message, T data) {
        super();
        this.status = status;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 成功返回结果
     * @Author GK
     * @Date Created in 2021/1/25 9:53
     * @param data: 数据
     * @Return
     */
    public static<T> R<T> ok(T data) {
        return new R<T>(ApiCode.SUCCESS.getStatus(), ApiCode.SUCCESS.getCode(), ApiCode.SUCCESS.getMessage(), data);
    }

    /**
     * 成功返回结果
     * @Author GK
     * @Date Created in 2021/1/25 9:54
     * @param message: 提示信息
     * @param data: 数据
     * @Return
     */
    public static<T> R<T> ok(String message, T data) {
        return new R<T>(ApiCode.SUCCESS.getStatus(), ApiCode.SUCCESS.getCode(), message, data);
    }

    /**
     * 成功返回结果
     * @Author GK
     * @Date Created in 2021/1/25 9:56
     * @Return
     */
    public static<T> R<T> ok() {
        return new R<T>(ApiCode.SUCCESS.getStatus(), ApiCode.SUCCESS.getCode(), ApiCode.SUCCESS.getMessage(), null);
    }

    /**
     * 失败返回结果
     * @Author GK
     * @Date Created in 2021/1/25 10:17
     * @param code: 错误码
     * @Return
     */
    public static<T> R<T> fail(ErrorCode code) {
        return new R<T>(code.getStatus(), code.getCode(), code.getMessage(), null);
    }

    /**
     * 失败返回结果
     * @Author GK
     * @Date Created in 2021/1/25 10:20
     * @param code: 错误码
     * @param message: 错误提示
     * @Return
     */
    public static<T> R<T> fail(ErrorCode code, String message) {
        return new R<T>(code.getStatus(), code.getCode(), message, null);
    }
    
    /**
     * 参数验证失败返回结果
     * @Author GK 
     * @Date Created in 2021/1/25 10:27
     * @Return
     */
    public static<T> R<T> validateFailed() {
        return fail(ApiCode.VALIDATE_FAILED);
    }

    /**
     * 参数验证失败返回结果
     * @Author GK
     * @Date Created in 2021/1/25 10:29
     * @Return
     */
    public static<T> R<T> validateFailed(String message) {
        return fail(ApiCode.VALIDATE_FAILED, message);
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
