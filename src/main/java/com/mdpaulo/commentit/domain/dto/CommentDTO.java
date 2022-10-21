package com.mdpaulo.commentit.domain.dto;

import com.mdpaulo.commentit.domain.models.Comment;

public record CommentDTO(String text, String user) {
    public CommentDTO(Comment comment) {
        this(comment.getText(),comment.getAuthor().getName());
    }
}
