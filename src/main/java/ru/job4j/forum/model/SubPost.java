package ru.job4j.forum.model;

import lombok.Data;
import lombok.ToString;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.util.Calendar;

/**
 * @author Egor Geraskin(yegeraskin13@gmail.com)
 * @version 1.0
 * @since 26.02.2021
 */
@Data
@Entity
@Table(name = "subpost")
public class SubPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "header")
    private String header;

    @Column(name = "content")
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created")
    private Calendar created;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "posts_id")
    private Post post;

    private String author;
}
