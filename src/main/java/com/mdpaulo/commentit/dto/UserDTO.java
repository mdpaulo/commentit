package com.mdpaulo.commentit.dto;

import com.mdpaulo.commentit.domain.models.User;

public record UserDTO(String id, String name, String email) {
    public UserDTO(User user) {
        this(user.getId(),
                user.getName(),
                user.getEmail());
    }
}
