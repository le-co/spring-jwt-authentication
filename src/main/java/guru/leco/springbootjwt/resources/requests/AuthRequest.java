package guru.leco.springbootjwt.resources.requests;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class AuthRequest {

    private String username;
    private String password;
}
