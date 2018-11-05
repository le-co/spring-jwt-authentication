package guru.leco.springbootjwt.resources.responses;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Builder
@Getter
public class UserResponse {
    private Integer id;
    private String username;
    private String name;
    private String address;
    private String city;
    private String cellphone;
}
