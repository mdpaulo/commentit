package com.mdpaulo.commentit.service;

import com.mdpaulo.commentit.domain.exceptions.CommentItException;
import com.mdpaulo.commentit.domain.exceptions.CommentItNotFoundException;
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
        this.validateUser(id);
        return repo.findById(id).orElseThrow(() -> new CommentItException(500, "failed to get user with id: "+id));
    }

    public User save(User user){
        return repo.insert(user);
    }

    public void deleteById(String id){
        this.validateUser(id);
        repo.deleteById(id);
    }

    private void validateUser(String id){
        if (!repo.existsById(id)){
            throw new CommentItNotFoundException(404, "User with id "+id+" not found");
        }
    }
}
