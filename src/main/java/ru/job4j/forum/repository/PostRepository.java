package ru.job4j.forum.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.SubPost;

import java.util.Set;

/**
 * @author Egor Geraskin(yegeraskin13@gmail.com)
 * @version 1.0
 * @since 25.02.2021
 */
public interface PostRepository extends CrudRepository<Post, Integer> {
    Post findById(int id);
    Iterable<Post> findByOrderByIdAsc();
}
