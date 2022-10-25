package com.mdpaulo.commentit.repository;

import com.mdpaulo.commentit.domain.models.Post;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    List<Post> findByTitleContainingIgnoreCase(String title);

    @Query("{'author.name': { $regex: ?0, $options: 'i' }}")
    List<Post> findByAuthorName(String name);
}
