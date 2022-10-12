package com.mdpaulo.commentit.controller;

import com.mdpaulo.commentit.domain.models.User;
import com.mdpaulo.commentit.dto.CreateUserDTO;
import com.mdpaulo.commentit.dto.UpdateUserDTO;
import com.mdpaulo.commentit.dto.UserDTO;
import com.mdpaulo.commentit.service.UserService;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody CreateUserDTO newUser){
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(service.save(newUser.generateModel()).getId())
                .toUri();
        return  ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable @NonNull String id, @RequestBody @NonNull UpdateUserDTO user){
        User userToUpdate= user.generateModel();
        userToUpdate.setId(id);
        service.update(userToUpdate);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable @NonNull String id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
