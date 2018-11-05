package guru.leco.springbootjwt.services;

import guru.leco.springbootjwt.models.User;
import guru.leco.springbootjwt.resources.responses.UserResponse;
import guru.leco.springbootjwt.services.jpa.UserServiceImp;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImpTest {

    private User user;

    @Autowired
    private UserServiceImp userService;

    @Before
    public void setUp() throws Exception {
        this.user = new User();
        user.setUsername("lcosta5");
        user.setName("Leandro costa");
        user.setCellphone("111111111");
        user.setCity("test");
        user.setPassword("aaaaaa");
    }

    @Test
    public void testCreateUser() {
        UserResponse userSaved = this.userService.save(user);
        assert userSaved.getId() != null;
    }

    @Test
    public void testAuthenticationSuccess() {
        UserResponse userSaved = this.userService.save(user);
        assert userSaved.getId() != null;

        UserResponse authentication = this.userService.authentication(userSaved.getUsername(), this.user.getPassword());

        assert authentication != null;
    }

    @Test
    public void testFindAll() {
        UserResponse userSaved = this.userService.save(user);
        assert userSaved.getId() != null;

        List<UserResponse> users = this.userService.findAll();

        assert users.size() > 0;
    }
}
