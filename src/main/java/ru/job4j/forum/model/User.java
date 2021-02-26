package ru.job4j.forum.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Egor Geraskin(yegeraskin13@gmail.com)
 * @version 1.0
 * @since 25.02.2021
 */
@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    @ManyToOne
    private Authority authority;
    private boolean enabled;

    public static User of(String name, String pass) {
        User user = new User();
        user.username = name;
        user.password = pass;
        return user;
    }
}
