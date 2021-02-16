package com.hsy.common.handler;

import com.hsy.common.api.ApiCode;
import com.hsy.common.api.R;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 * @Author: gk
 * @Date: Created in 2021/2/6 10:00
 */
@RestControllerAdvice
@Component
@ResponseBody
public class GlobalExceptionHandler {
    // 这里可以先捕捉logger

    /**
     * 入参校验
     * @Author gk on 2021/2/10 下午4:23
     * @return R<Object>
     * @Description:
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public R<Object> handle(MethodArgumentNotValidException exception) {
        String message = exception.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        return R.fail(ApiCode.PARAM_ERROR, message);
    }
}
