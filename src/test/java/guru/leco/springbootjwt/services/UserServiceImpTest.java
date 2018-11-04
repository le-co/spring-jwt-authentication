package guru.leco.springbootjwt.services;

import guru.leco.springbootjwt.models.User;
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
        user.setPassword("abc1234");
    }

    @Test
    public void testCreateUser() {
        User userSaved = this.userService.save(user);
        assert userSaved.getId() != null;
    }

    @Test
    public void testAuthenticationSuccess() {
        User userSaved = this.userService.save(user);
        assert userSaved.getId() != null;

        User user = this.userService.authentication(userSaved.getUsername(), userSaved.getPassword());

        assert user != null;

        assert user.getId() == userSaved.getId();
    }

    @Test
    public void testFindAll() {
        User userSaved = this.userService.save(user);
        assert userSaved.getId() != null;

        List<User> users = this.userService.findAll();

        assert users.size() > 0;
    }
}
