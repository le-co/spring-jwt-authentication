package guru.leco.springbootjwt.services;

import guru.leco.springbootjwt.models.User;
import guru.leco.springbootjwt.resources.responses.UserResponse;

public interface UserService extends CrudService<UserResponse, User> {

    UserResponse authentication(String username, String password);
}
