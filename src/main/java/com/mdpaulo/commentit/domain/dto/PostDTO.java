package com.mdpaulo.commentit.domain.dto;

import com.mdpaulo.commentit.domain.models.Post;
import java.time.LocalDateTime;
import java.time.ZoneId;

public record PostDTO(
        String id,
        LocalDateTime createAt,
        String title,
        AuthorDTO author) {

    public PostDTO(Post post) {
        this(
                post.getId(),
                LocalDateTime.ofInstant(post.getDate(), ZoneId.of("America/Sao_Paulo")),
                post.getTitle(),
                new AuthorDTO(post.getAuthor())
        );
    }
}
