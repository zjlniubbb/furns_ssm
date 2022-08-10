package com.zzz.book.util;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author zjlniubbb
 * @version 1.0
 */
@RestControllerAdvice
public class EA {

    @ExceptionHandler
    public MyUtils doException(Exception e){

        e.printStackTrace();
        return new MyUtils(false,"服务器故障，请稍后再试！");
    }

}
