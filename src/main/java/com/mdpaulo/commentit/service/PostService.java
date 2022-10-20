package com.mdpaulo.commentit.service;

import com.mdpaulo.commentit.domain.exceptions.CommentItException;
import com.mdpaulo.commentit.domain.exceptions.CommentItNotFoundException;
import com.mdpaulo.commentit.domain.models.Post;
import com.mdpaulo.commentit.repository.PostRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    private PostRepository repo;

    public List<Post> findAll(){
        return repo.findAll();
    }

    public Post findById(String id){
        this.validatePost(id);
        return repo.findById(id).orElseThrow(() -> new CommentItException(500, "Failed to get post with id: "+id));
    }

    public Post save(Post post){
        return repo.insert(post);
    }

    public Post update(Post post){
        this.validatePost(post.getId());
        return repo.save(post);
    }

    private void validatePost(String id){
        if (!repo.existsById(id)){
            throw new CommentItNotFoundException(404, "Post with id "+id+" not found");
        }
    }
}
