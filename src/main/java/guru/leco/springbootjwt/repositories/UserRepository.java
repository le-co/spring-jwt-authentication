package guru.leco.springbootjwt.repositories;

import guru.leco.springbootjwt.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findFirstByUsernameAndPassword(String username, String password);
}
