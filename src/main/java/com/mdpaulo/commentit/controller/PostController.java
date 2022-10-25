package com.mdpaulo.commentit.controller;

import com.mdpaulo.commentit.domain.dto.PostDTO;
import com.mdpaulo.commentit.service.PostService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService service;

    @GetMapping
    public ResponseEntity<List<PostDTO>> findAll(){
        return ResponseEntity.ok().body(service.findAll()
                .stream()
                .map(PostDTO::new)
                .toList());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PostDTO> findById(@PathVariable @NonNull String id){
        return ResponseEntity.ok().body(new PostDTO(service.findById(id)));
    }

    @GetMapping(value = "/title")
    public ResponseEntity<List<PostDTO>> findByTitle(@RequestParam(value = "text", defaultValue = "") @NonNull String title){
        return ResponseEntity.ok().body(service.findByTitle(title).stream()
                .map(PostDTO::new)
                .toList());
    }

    @GetMapping(value = "/author")
    public ResponseEntity<List<PostDTO>> findByAuthorName(@RequestParam(value = "name", defaultValue = "") @NonNull String name){
        return ResponseEntity.ok().body(service.findByAuthorName(name).stream()
                .map(PostDTO::new)
                .toList());
    }
}
