package com.example.sharefekhair.advice;

import com.example.sharefekhair.DTO.ResponseAPI;
import com.example.sharefekhair.exceptions.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Objects;

@RestControllerAdvice
public class ControllerAdviceHandler {

    Logger logger = LoggerFactory.getLogger(ControllerAdviceHandler.class);

    @ExceptionHandler(value = StudentNotFoundException.class)
    public ResponseEntity<ResponseAPI<?>> StudentNotFoundException(StudentNotFoundException e) {
        logger.warn("StudentNotFoundException => provoked!\n"+e.getMessage());
        return ResponseEntity.status(400).body(new ResponseAPI<>(e.getMessage(),400));
    }

    @ExceptionHandler(value = MyClassNotFoundException.class)
    public ResponseEntity<ResponseAPI<?>> MyClassNotFoundException(MyClassNotFoundException e) {
        logger.warn("MyClassNotFoundException => provoked!\n"+e.getMessage());
        return ResponseEntity.status(400).body(new ResponseAPI<>(e.getMessage(),400));
    }

    @ExceptionHandler(value = TeacherNotFoundException.class)
    public ResponseEntity<ResponseAPI<?>> TeacherNotFoundException(TeacherNotFoundException e) {
        logger.warn("TeacherNotFoundException => provoked!\n"+e.getMessage());
        return ResponseEntity.status(400).body(new ResponseAPI<>(e.getMessage(),400));
    }

    @ExceptionHandler(value = UserIdNotFoundException.class)
    public ResponseEntity<ResponseAPI<?>> UserIdNotFoundException(UserIdNotFoundException e) {
        logger.warn("UserIdNotFoundException => provoked!\n"+e.getMessage());
        return ResponseEntity.status(400).body(new ResponseAPI<>(e.getMessage(),400));
    }

    @ExceptionHandler(value = SessionIdNotFoundException.class)
    public ResponseEntity<ResponseAPI<?>> SessionIdNotFoundException(SessionIdNotFoundException e) {
        logger.warn("SessionIdNotFoundException => provoked!\n"+e.getMessage());
        return ResponseEntity.status(400).body(new ResponseAPI<>(e.getMessage(),400));
    }

    @ExceptionHandler(value = IllegalStateException.class)
    public ResponseEntity<ResponseAPI<?>> IllegalStateException(IllegalStateException e) {
        logger.warn("IllegalStateException => provoked!\n"+e.getMessage());
        return ResponseEntity.status(400).body(new ResponseAPI<>(e.getMessage(),400));
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseAPI<?>> MethodArgumentNotValidException(MethodArgumentNotValidException mane){
        logger.warn("MethodArgumentNotValidException => provoked!\n"+ Objects.requireNonNull(mane.getFieldError()).getDefaultMessage());
        return ResponseEntity.status(400).body(new ResponseAPI<>(mane.getFieldError().getDefaultMessage(),400));
    }

    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public ResponseEntity<ResponseAPI<?>> DataIntegrityViolationException(DataIntegrityViolationException dt){
        logger.warn("DataIntegrityViolationException => provoked!\n"+dt.getRootCause());
        return ResponseEntity.status(400).body(new ResponseAPI<>(Objects.requireNonNull(dt.getRootCause()).getMessage(),400));
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ResponseAPI<?>> Exception(Exception e) {
        StringWriter stringWriter=new StringWriter();
        e.printStackTrace(new PrintWriter(stringWriter));
        logger.error("Exception => provoked!\n"+stringWriter );

        return ResponseEntity.status(500).body(new ResponseAPI<>("Server Error",500));
    }
}
