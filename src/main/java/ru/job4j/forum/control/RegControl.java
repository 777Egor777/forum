package ru.job4j.forum.control;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.forum.model.User;
import ru.job4j.forum.repository.AuthorityRepository;
import ru.job4j.forum.repository.UserRepository;

import java.lang.reflect.GenericDeclaration;

/**
 * @author Egor Geraskin(yegeraskin13@gmail.com)
 * @version 1.0
 * @since 25.02.2021
 */
@Controller
public class RegControl {
    private final UserRepository userRep;
    private final AuthorityRepository authRep;
    private final PasswordEncoder encoder;

    public RegControl(UserRepository userRep, AuthorityRepository authRep, PasswordEncoder encoder) {
        this.userRep = userRep;
        this.authRep = authRep;
        this.encoder = encoder;
    }

    @GetMapping("/reg")
    public String reg() {
        return "reg";
    }

    @PostMapping("/reg")
    public String save(@ModelAttribute User user) {
        System.out.println("\n\n" + user + "\n\n");

        user.setEnabled(true);
        user.setPassword(encoder.encode(user.getPassword()));
        user.setAuthority(authRep.findByAuthority("ROLE_USER"));
        userRep.save(user);
        return "redirect:/login";
    }
}
