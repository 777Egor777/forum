package ru.job4j.forum.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.forum.model.SubPost;

/**
 * @author Egor Geraskin(yegeraskin13@gmail.com)
 * @version 1.0
 * @since 25.02.2021
 */
public interface SubPostRepository extends CrudRepository<SubPost, Integer> {
    Iterable<SubPost> findAllByPostIdOrderByIdAsc(int id);
}
