package com.mdpaulo.commentit.controller;

import com.mdpaulo.commentit.domain.exceptions.CommentItException;
import com.mdpaulo.commentit.domain.exceptions.ResponseErrorTemplate;
import java.time.Instant;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerErrorHandler {

    @ExceptionHandler(CommentItException.class)
    public ResponseEntity<ResponseErrorTemplate> handleApplicationException(CommentItException error, HttpServletRequest request){
        HttpStatus status = error.getResponseCode() != null ? HttpStatus.valueOf(error.getResponseCode()) : HttpStatus.BAD_REQUEST;
        ResponseErrorTemplate responseError = new ResponseErrorTemplate(Instant.now(), request.getRequestURI(), error.getMessage());
        return ResponseEntity.status(status).body(responseError);
    }
}
