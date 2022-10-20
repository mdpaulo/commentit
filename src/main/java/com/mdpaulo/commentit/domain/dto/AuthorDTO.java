package com.mdpaulo.commentit.domain.dto;

import com.mdpaulo.commentit.domain.models.Author;

public record AuthorDTO(String id, String name) {
    public AuthorDTO(Author author) {
        this(author.getId(), author.getName());
    }
}
