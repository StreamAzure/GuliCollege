package com.stream.exceptionHandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stream.commonutils.R;

@ControllerAdvice
public class GlobalExceptionHandler {
    // 指定出现什么异常时执行本方法
    @ExceptionHandler(Exception.class)
    @ResponseBody // 为了返回数据，不在Controller中所以没有@RestController
    public R error(Exception e){
        e.printStackTrace();
        return R.error().message("执行了全局异常处理");
    }
}
