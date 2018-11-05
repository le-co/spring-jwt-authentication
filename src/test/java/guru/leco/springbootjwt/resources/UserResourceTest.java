package guru.leco.springbootjwt.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import guru.leco.springbootjwt.models.User;
import guru.leco.springbootjwt.resources.responses.UserResponse;
import guru.leco.springbootjwt.services.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserService userService;

    private String json;

    private User user;

    @Before
    public void setUp() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        this.user = new User();
        user.setUsername("lcosta5");
        user.setName("Leandro costa");
        user.setCellphone("111111111");
        user.setCity("test");
        user.setPassword("aaaaaa");

        this.json = objectMapper.writeValueAsString(user);
    }

    @Test
    public void create() throws Exception {
        this.mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(this.json))
                .andExpect(status().isCreated());

    }


    @Test
    public void findById() throws Exception {
        UserResponse response = this.userService.save(user);

        String url = "/users/" + response.getId().toString();

        this.mockMvc.perform(get(url))
                .andExpect(status().is(200));
    }
}
