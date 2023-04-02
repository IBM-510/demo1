package com.example.demo.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LoginExceptionHandler {

    @ExceptionHandler(LoginException.class)
    public String loginExceptionHandler(LoginException loginException){
        return "redirect:/index.html";
    }
}
