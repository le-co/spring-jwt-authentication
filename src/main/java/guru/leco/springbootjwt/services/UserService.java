package guru.leco.springbootjwt.services;

import guru.leco.springbootjwt.models.User;

public interface UserService extends CrudService<User, Integer> {

    User authentication(String username, String password);
}
