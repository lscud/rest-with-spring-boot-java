package com.scud.project.handler;

import com.scud.project.exception.StandardErrorResource;
import com.scud.project.exception.UnsupportedMathOperationException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ExceptionHandlerResource {

    @ExceptionHandler(UnsupportedMathOperationException.class)
    public ResponseEntity<StandardErrorResource> handleAllExceptions(UnsupportedMathOperationException e, HttpServletRequest request){
        String error = "Please set a numeric value";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardErrorResource err = new StandardErrorResource(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }


    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<StandardErrorResource> database(RuntimeException e, HttpServletRequest request){
        String error = "database error ";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardErrorResource err = new StandardErrorResource(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
