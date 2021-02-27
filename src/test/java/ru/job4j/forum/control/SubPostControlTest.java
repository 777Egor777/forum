package ru.job4j.forum.control;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import ru.job4j.forum.Main;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.SubPost;
import ru.job4j.forum.service.PostService;
import ru.job4j.forum.service.SubPostService;

@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
public class SubPostControlTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SubPostService subServ;

    @Test
    @WithMockUser
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/post")
                             .param("postId", "2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("post"));
    }

    @Test
    @WithMockUser
    public void shouldReturnDefaultMessagePostMethod() throws Exception {
        this.mockMvc.perform(post("/subpost/save")
                .param("header", "Куплю ладу-грант. Дорого.")
                .param("postId", "1"))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
        ArgumentCaptor<SubPost> argument = ArgumentCaptor.forClass(SubPost.class);
        verify(subServ).save(argument.capture());
        assertThat(argument.getValue().getHeader(), is("Куплю ладу-грант. Дорого."));
    }
}