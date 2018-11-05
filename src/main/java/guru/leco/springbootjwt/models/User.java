package guru.leco.springbootjwt.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank
    private String username;

    @NotBlank
    @Column(precision = 60)
    private String password;

    private String name;

    private String address;

    private String city;

    private String cellphone;
}
