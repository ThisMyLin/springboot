package com.xiaozhai.Exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    public Responses handle(Exception e){
        Responses responses = new Responses();
        responses.setCode(-1);
        responses.setMsg(e.getMessage());
        responses.setData(null);
        return responses;
    }
}
