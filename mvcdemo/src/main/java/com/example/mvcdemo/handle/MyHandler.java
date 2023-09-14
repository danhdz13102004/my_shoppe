package com.example.mvcdemo.handle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class MyHandler {
    @ExceptionHandler
    public ResponseEntity<ErrorRespond> checkAll(Exception ex) {
        ErrorRespond err = new ErrorRespond(HttpStatus.BAD_REQUEST.value(), "Loi roi may oi!");
        System.out.println(err);
        try {
            return ResponseEntity.badRequest().body(err);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
