package ru.job4j.forum.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Egor Geraskin(yegeraskin13@gmail.com)
 * @version 1.0
 * @since 25.02.2021
 */
@Data
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    public static Post of(String name, String desc) {
        Post post = new Post();
        post.name = name;
        post.description = desc;
        return post;
    }
}
