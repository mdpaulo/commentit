package com.mdpaulo.commentit.domain.exceptions;

public class CommentItNotFoundException extends CommentItException{
    public CommentItNotFoundException(Integer responseCode, String message) {
        super(responseCode, message);
    }
}
