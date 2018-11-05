package guru.leco.springbootjwt.services.jpa;

import guru.leco.springbootjwt.repositories.UserRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Profile("jpa")
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        guru.leco.springbootjwt.models.User userFound = userRepository.findByUsername(username);
        if (userFound == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(userFound.getUsername(), userFound.getPassword(), emptyList());
    }
}
