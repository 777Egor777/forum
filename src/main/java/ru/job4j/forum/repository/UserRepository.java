package ru.job4j.forum.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.forum.model.User;

/**
 * @author Egor Geraskin(yegeraskin13@gmail.com)
 * @version 1.0
 * @since 25.02.2021
 */
public interface UserRepository extends CrudRepository<User, Integer> {
}
