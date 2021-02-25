package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.repository.PostRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Egor Geraskin(yegeraskin13@gmail.com)
 * @version 1.0
 * @since 25.02.2021
 */
@Service
public class PostService {
    private final PostRepository rep;

    public PostService(PostRepository rep) {
        this.rep = rep;
    }

    public List<Post> getAll() {
        List<Post> result = new LinkedList<>();
        rep.findAll().forEach(result::add);
        return result;
    }

    public Post save(Post post) {
        if (post.getId() == 0) {
            post.setCreated(new Date(System.currentTimeMillis()));
        }
        rep.save(post);
        return post;
    }

    public Post get(Integer id) {
        return rep.findById(id).orElse(null);
    }
}
