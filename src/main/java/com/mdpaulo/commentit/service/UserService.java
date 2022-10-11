package com.mdpaulo.commentit.service;

import com.mdpaulo.commentit.domain.exceptions.CommentItException;
import com.mdpaulo.commentit.domain.models.User;
import com.mdpaulo.commentit.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    public List<User> findAll(){
        return repo.findAll();
    }

    public User findById(String id){
        return repo.findById(id).orElseThrow(() -> new CommentItException(404, "failed to find User with id: "+id));
    }
}