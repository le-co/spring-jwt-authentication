package guru.leco.springbootjwt.services.jpa;

import guru.leco.springbootjwt.converter.UserDomainToUserResponse;
import guru.leco.springbootjwt.models.User;
import guru.leco.springbootjwt.repositories.UserRepository;
import guru.leco.springbootjwt.resources.responses.UserResponse;
import guru.leco.springbootjwt.services.UserService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Profile("jpa")
public class UserServiceImp implements UserService {

    private UserRepository userRepository;
    private UserDomainToUserResponse domainToUserResponse;

    public UserServiceImp(UserRepository userRepository, UserDomainToUserResponse domainToUserResponse) {
        this.userRepository = userRepository;
        this.domainToUserResponse = domainToUserResponse;
    }

    @Override
    public UserResponse save(User object) {
        return this.domainToUserResponse.convert(this.userRepository.save(object));
    }

    @Override
    public UserResponse findById(Integer id) {
        return this.domainToUserResponse.convert(this.userRepository.getOne(id));
    }

    @Override
    public List<UserResponse> findAll() {
        return this.userRepository.findAll().stream().map(p -> this.domainToUserResponse.convert(p)).collect(Collectors.toList());
    }

    @Override
    public void removeById(Integer id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public UserResponse update(Integer id, User object) {
        User user = this.userRepository.getOne(id);
        if (user != null) {
            return this.domainToUserResponse.convert(this.userRepository.save(object));
        }
        throw new NullPointerException("User does not exists");
    }

    @Override
    public UserResponse authentication(String username, String password) {
        User user = this.userRepository.findFirstByUsernameAndPassword(username, password);
        if (user == null) {
            throw new NullPointerException("Authentication fail, user or password not match!!!");
        }
        return this.domainToUserResponse.convert(user);
    }
}
