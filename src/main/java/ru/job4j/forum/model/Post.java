package ru.job4j.forum.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Calendar;

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
    private String desc;
    private Calendar created = Calendar.getInstance();

    public static Post of(String name, String desc) {
        Post post = new Post();
        post.name = name;
        post.desc = desc;
        post.created = Calendar.getInstance();
        return post;
    }
}
