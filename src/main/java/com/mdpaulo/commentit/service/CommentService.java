package com.mdpaulo.commentit.service;

import com.mdpaulo.commentit.domain.exceptions.CommentItException;
import com.mdpaulo.commentit.domain.exceptions.CommentItNotFoundException;
import com.mdpaulo.commentit.domain.models.Comment;
import com.mdpaulo.commentit.domain.models.Post;
import com.mdpaulo.commentit.repository.CommentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    private CommentRepository repo;

    public List<Comment> findAll(){
        return repo.findAll();
    }

    public Comment findById(String id){
        this.validateComment(id);
        return repo.findById(id).orElseThrow(() -> new CommentItException(500, "Failed to get post with id: "+id));
    }

    public Comment save(Comment comment){
        return repo.insert(comment);
    }

    public Comment update(Comment comment){
        this.validateComment(comment.getId());
        return repo.save(comment);
    }

    public void deleteById(String id){
        this.validateComment(id);
        repo.deleteById(id);
    }

    private void validateComment(String id){
        if (!repo.existsById(id)){
            throw new CommentItNotFoundException(404, "Comment with id "+id+" not found");
        }
    }
}
