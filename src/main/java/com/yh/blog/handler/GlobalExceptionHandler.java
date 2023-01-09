package com.yh.blog.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

//모든 오류 발생시 이페이지로 들어오게하는 어노테이션 
@ControllerAdvice
@RestController
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = Exception.class)
	public String handelArgmentException(IllegalArgumentException e) {
		return "<h1>"+e.getMessage()+"</h1>";
	}

}
