package com.mdpaulo.commentit.controller;

import com.mdpaulo.commentit.domain.models.User;
import com.mdpaulo.commentit.dto.UserDTO;
import com.mdpaulo.commentit.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        return ResponseEntity.ok().body(service.findAll()
                .stream()
                .map(UserDTO::new)
                .toList());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable @NonNull String id){
        return ResponseEntity.ok().body(new UserDTO(service.findById(id)));
    }
}
