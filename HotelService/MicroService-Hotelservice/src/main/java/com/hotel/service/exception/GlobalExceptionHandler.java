package com.hotel.service.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    public ResponseEntity<Map<String, String>> notFound(ResourceNotFoundException exception) {
        Map<String, String> map = new HashMap<>();
        map.put("message", exception.getMessage());
        map.put("status", "404");
        map.put("success", "false");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);

    }

}
