package com.hsy.common.api;

/*
|--------------------------------------------------------------------------
| API 状态码
|--------------------------------------------------------------------------
| 各个服务统一返回状态码： 成功状态码为0 错误状态码统一4位数 不同的模块指定不同的开头数字
| 成功: 0
| 全局错误： 1开头
*/
public class ApiCode {

    public static final int OK = 0;

    // 登录失败
    public static final int LOGINERROR = 1001;

    // 权限不足
    public static final int ACCESSERROR = 1002;


}
