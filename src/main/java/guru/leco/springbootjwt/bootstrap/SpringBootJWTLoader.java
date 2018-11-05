package guru.leco.springbootjwt.bootstrap;

import guru.leco.springbootjwt.models.User;
import guru.leco.springbootjwt.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SpringBootJWTLoader implements CommandLineRunner {

    private UserService userService;

    @Autowired
    public SpringBootJWTLoader(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setAddress("rua marte");

        user.setCity("barueri");
        user.setCellphone("1111111");
        user.setName("leco");
        user.setUsername("leco");
        user.setPassword("abc1234");

        User user1 = new User();
        user1.setAddress("rua araras");
        user1.setCity("barueri");
        user1.setCellphone("1111111");
        user1.setName("bruno");
        user1.setUsername("bmoraes");
        user1.setPassword("abc1234");

        this.userService.save(user);
        this.userService.save(user1);
    }
}
