package guru.leco.springbootjwt.services.jpa;

import guru.leco.springbootjwt.models.User;
import guru.leco.springbootjwt.repositories.UserRepository;
import guru.leco.springbootjwt.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("jpa")
public class UserServiceImp implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User object) {
        return this.userRepository.save(object);
    }

    @Override
    public User findById(Integer id) {
        return this.userRepository.getOne(id);
    }

    @Override
    public List<User> findAll() {
        return this.findAll();
    }

    @Override
    public void removeById(Integer id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public User update(Integer id, User object) {
        User user = this.userRepository.getOne(id);
        if (user != null) {
            this.userRepository.save(object);
        }
        throw new NullPointerException("User does not exists");
    }

    @Override
    public User authentication(String username, String password) {
        User user = this.userRepository.findByUsernameAndPassword(username, password);
        if (user == null) {
            throw new NullPointerException("Authentication fail, user or password not match!!!");
        }
        return user;
    }
}
