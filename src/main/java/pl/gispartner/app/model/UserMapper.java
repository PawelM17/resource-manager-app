package pl.gispartner.app.model;

public class UserMapper {

    public static UserEntity mapToEntity(UserDto userDto) {
        return UserEntity.builder()
                .id(userDto.getId())
                .name(userDto.getName())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .userType(userDto.getUserType())
                .build();
    }

    public static UserDto mapToDto(UserEntity userEntity) {
        return UserDto.builder()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .userType(userEntity.getUserType())
                .build();
    }
}
