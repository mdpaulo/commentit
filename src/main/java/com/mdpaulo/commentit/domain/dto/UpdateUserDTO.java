package com.mdpaulo.commentit.domain.dto;

import com.mdpaulo.commentit.domain.models.User;

public record UpdateUserDTO(String name, String email) {
    public User generateModel(){
        return new User(null, this.name, this.email);
    }
}
