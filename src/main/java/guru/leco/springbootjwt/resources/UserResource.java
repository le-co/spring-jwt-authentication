package guru.leco.springbootjwt.resources;

import guru.leco.springbootjwt.converter.UserDomainToUserResponse;
import guru.leco.springbootjwt.models.User;
import guru.leco.springbootjwt.resources.responses.UserResponse;
import guru.leco.springbootjwt.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import java.net.URI;
import java.net.URISyntaxException;

import static guru.leco.springbootjwt.resources.UserResource.ROUTE;

@RestController
@RequestMapping(ROUTE)
public class UserResource {

    static final String ROUTE = "/users";

    private UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},
            consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity create(@RequestBody User user) throws URISyntaxException {
        UserResponse userResponse = this.userService.save(user);
        return ResponseEntity.created(new URI(ROUTE + "/" + userResponse.getId())).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(this.userService.findById(id));
        } catch (NullPointerException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
