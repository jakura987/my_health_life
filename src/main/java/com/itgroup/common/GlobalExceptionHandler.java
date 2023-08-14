package com.itgroup.common;

import com.itgroup.exception.BusinessException;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = {RestController.class, Controller.class})
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public R<String> BusinessExceptionHandler(BusinessException ex){
        log.error(ex.getMessage());
        return R.error(ex.getMessage());
    }

    @ExceptionHandler(ExpiredJwtException.class)
    public R<String> ExpiredJwtException(ExpiredJwtException ex){
        System.out.println("333");
        log.error(ex.getMessage());
        return R.error(ex.getMessage());
    }
}
