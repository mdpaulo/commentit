package com.mdpaulo.commentit.domain.exceptions;

import java.io.Serial;
import lombok.Getter;

public class CommentItException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;

    @Getter
    private Integer responseCode;

    public CommentItException(Integer responseCode, String message, Exception exception){
        super(message,exception);
        this.responseCode = responseCode;
    }

    public CommentItException(Integer responseCode, String message){
        super(message);
        this.responseCode =  responseCode;
    }
    public CommentItException(String message, Exception exception){
        super(message,exception);
    }

    public CommentItException(String message){
        super(message);
    }

    public CommentItException(Exception exception){
        super(exception);
    }

    public CommentItException(){}
}
