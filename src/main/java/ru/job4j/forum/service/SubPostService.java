package ru.job4j.forum.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.job4j.forum.model.SubPost;
import org.springframework.security.core.userdetails.User;
import ru.job4j.forum.repository.SubPostRepository;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Egor Geraskin(yegeraskin13@gmail.com)
 * @version 1.0
 * @since 26.02.2021
 */
@Service
public class SubPostService {
    private final SubPostRepository rep;

    public SubPostService(SubPostRepository rep) {
        this.rep = rep;
    }

    public SubPost save(SubPost sub) {
        if (sub.getId() == 0) {
            sub.setCreated(Calendar.getInstance());
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            sub.setAuthor(user.getUsername());
        } else {
            SubPost sp = get(sub.getId());
            sub.setAuthor(sp.getAuthor());
            sub.setCreated(sp.getCreated());
        }
        rep.save(sub);
        return sub;
    }

    public SubPost get(Integer id) {
        return rep.findById(id).orElse(null);
    }

    public void delete(int id) {
        SubPost post = new SubPost();
        post.setId(id);
        rep.delete(post);
    }

    public List<SubPost> getAllByPostId(int id) {
        List<SubPost> result = new LinkedList<>();
        rep.findAllByPost_Id(id).forEach(result::add);
        return result;
    }
}
