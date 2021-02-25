package ru.job4j.forum.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author Egor Geraskin(yegeraskin13@gmail.com)
 * @version 1.0
 * @since 25.02.2021
 */
@Data
public class User {
    private int id;
    private String name;
    private String pass;

    public static User of(String name, String pass) {
        User user = new User();
        user.name = name;
        user.pass = pass;
        return user;
    }
}
