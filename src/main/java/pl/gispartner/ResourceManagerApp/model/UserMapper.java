package pl.gispartner.ResourceManagerApp.model;

import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserEntity mapToEntity(UserDto userDto) {
        return UserEntity.builder()
                .userId(userDto.getUserId())
                .name(userDto.getName())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .build();
    }
}
