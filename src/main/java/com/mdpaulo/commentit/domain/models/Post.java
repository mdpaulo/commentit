package com.mdpaulo.commentit.domain.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Document(collection = "posts")
public class Post implements Serializable {
    @Id
    private String id;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Instant date;
    private String title;
    private String body;
    private Author author;

    @DBRef
    @Setter(AccessLevel.NONE)
    private List<Comment> comments = new ArrayList<>();

    public Post(String id, Instant date, String title, String body, Author author) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.body = body;
        this.author = author;
    }
}
