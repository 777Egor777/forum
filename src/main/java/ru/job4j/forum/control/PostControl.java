package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostService;

/**
 * @author Egor Geraskin(yegeraskin13@gmail.com)
 * @version 1.0
 * @since 25.02.2021
 */
@Controller
public class PostControl {
    private final PostService service;

    public PostControl(PostService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Post post) {
        if (post.getId() != 0) {
            post.setCreated(service.get(post.getId()).getCreated());
        }
        service.save(post);
        return "redirect:/index";
    }

    @RequestMapping("/edit")
    public String edit(Model model,
                       @RequestParam(required = false) Integer id) {
        Post post = new Post();
        if (id != null) {
            post = service.get(id);
            System.out.println(id + " " + post);
        }
        model.addAttribute("post", post);
        return "edit";
    }

}
