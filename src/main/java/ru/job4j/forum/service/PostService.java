package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Egor Geraskin(yegeraskin13@gmail.com)
 * @version 1.0
 * @since 25.02.2021
 */
@Service
public class PostService {
    private final Map<Integer, Post> posts = new HashMap<>();
    private int id = 1;

    public PostService() {
        save(Post.of("Продаю машину ладу 01.", ""));
    }

    public List<Post> getAll() {
        return new ArrayList<>(posts.values());
    }

    public Post save(Post post) {
        if (post.getId() == 0) {
            post.setId(id);
            id++;
        }
        posts.put(post.getId(), post);
        return post;
    }

    public Post get(int id) {
        return posts.get(id);
    }
}
