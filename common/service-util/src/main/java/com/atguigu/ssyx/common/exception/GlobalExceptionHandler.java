package com.atguigu.ssyx.common.exception;


import com.atguigu.ssyx.common.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)  //异常处理器
    @ResponseBody //返回对象转成json格式返回
    public Result error(Exception e){
        e.printStackTrace();
        return Result.fail(null);
    }

    //自定义异常处理
    @ExceptionHandler(SsyxException.class)  //异常处理器
    @ResponseBody //返回对象转成json格式返回
    public Result error(SsyxException e){
        return Result.build(null,e.getCode(),e.getMessage());
    }
}
