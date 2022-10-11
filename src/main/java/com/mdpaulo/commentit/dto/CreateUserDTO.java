package com.mdpaulo.commentit.dto;

import com.mdpaulo.commentit.domain.models.User;

public record CreateUserDTO(String name, String email) {

    public User generateModel(){
        return new User(null, this.name, this.email);
    }
}
