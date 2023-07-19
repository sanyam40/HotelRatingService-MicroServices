package com.user.service.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.user.service.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, String>>handlerResourceNotFoundException(ResourceNotFoundException exception){
        
    	Map<String, String> map = new HashMap<>();
        map.put("message", exception.getMessage());
        map.put("status", "404");
        map.put("success", "false");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);

    }
    
}
