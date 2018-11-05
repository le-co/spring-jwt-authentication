package guru.leco.springbootjwt.converter;

import guru.leco.springbootjwt.models.User;
import guru.leco.springbootjwt.resources.responses.UserResponse;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UserDomainToUserResponse implements Converter<User, UserResponse> {

    @Nullable
    @Override
    public UserResponse convert(User user) {
        return UserResponse
                .builder()
                .address(user.getAddress())
                .cellphone(user.getCellphone())
                .city(user.getCity())
                .name(user.getName())
                .username(user.getUsername())
                .id(user.getId())
                .build();
    }
}
