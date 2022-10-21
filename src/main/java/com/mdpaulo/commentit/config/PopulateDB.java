package com.mdpaulo.commentit.config;

import com.mdpaulo.commentit.domain.models.Author;
import com.mdpaulo.commentit.domain.models.Comment;
import com.mdpaulo.commentit.domain.models.Post;
import com.mdpaulo.commentit.domain.models.User;
import com.mdpaulo.commentit.repository.CommentRepository;
import com.mdpaulo.commentit.repository.PostRepository;
import com.mdpaulo.commentit.repository.UserRepository;
import java.time.Instant;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("!prod")
public class PopulateDB implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(List.of(maria, alex, bob));

        Post post1 = new Post(null, Instant.now(), "Mudando o look","Cortei o cabelo, gostaram?", new Author(maria));
        Post post2 = new Post(null, Instant.now(), "Bom negocio","preciso de alguem que faça um serviço em troca de divulgação, tenho 10 seguidores!", new Author(maria));

        postRepository.saveAll(List.of(post1,post2));

        maria.getPosts().addAll(List.of(post1,post2));

        userRepository.save(maria);

        Comment comment1 = new Comment(null,"Você deveria ter vergonha", Instant.now(), new Author(alex));
        Comment comment2 = new Comment(null,"Me liga", Instant.now(), new Author(bob));
        Comment comment3 = new Comment(null, "Quanto?", Instant.now(), new Author(bob));

        commentRepository.saveAll(List.of(comment1,comment2,comment3));

        post1.getComments().add(comment2);
        post2.getComments().addAll(List.of(comment1,comment3));

        postRepository.saveAll(List.of(post1,post2));
    }
}
