package com.mdpaulo.commentit.domain.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Document(collection = "posts")
@EqualsAndHashCode(of = "id")
public class Post implements Serializable {
    @Id
    private String id;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Instant date;
    private String title;
    private String body;
    private Author author;
}
