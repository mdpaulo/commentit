package com.mdpaulo.commentit.domain.dto;

import com.mdpaulo.commentit.domain.models.Post;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

public record PostDTO(
        String id,
        LocalDateTime createAt,
        String title,
        String body,
        AuthorDTO author,
        List<CommentDTO> comments) {
    public PostDTO(Post post) {
        this(
                post.getId(),
                LocalDateTime.ofInstant(post.getDate(), ZoneId.of("America/Sao_Paulo")),
                post.getTitle(),
                post.getBody(),
                new AuthorDTO(post.getAuthor()),
                post.getComments().stream().map(CommentDTO::new).toList()
        );
    }
}
