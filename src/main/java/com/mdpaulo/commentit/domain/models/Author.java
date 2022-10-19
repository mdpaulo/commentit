package com.mdpaulo.commentit.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    private String id;
    private String name;

    public Author(User user) {
        this.id = user.getId();
        this.name = user.getName();
    }
}
