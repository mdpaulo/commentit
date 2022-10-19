package com.mdpaulo.commentit.repository;

import com.mdpaulo.commentit.domain.models.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
