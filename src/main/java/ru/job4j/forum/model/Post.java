package ru.job4j.forum.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.*;

/**
 * @author Egor Geraskin(yegeraskin13@gmail.com)
 * @version 1.0
 * @since 25.02.2021
 */
@Data
@ToString(exclude = "subs")
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private String author;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar created;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SubPost> subs = new ArrayList<>();

    public static Post of(String name, String desc) {
        Post post = new Post();
        post.name = name;
        post.description = desc;
        return post;
    }
}
