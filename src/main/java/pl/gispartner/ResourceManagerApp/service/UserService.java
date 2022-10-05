package pl.gispartner.ResourceManagerApp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.gispartner.ResourceManagerApp.model.UserDto;
import pl.gispartner.ResourceManagerApp.model.UserEntity;
import pl.gispartner.ResourceManagerApp.model.UserMapper;
import pl.gispartner.ResourceManagerApp.persistance.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public Long saveUser(UserDto userDto) {
        UserEntity userEntity = userRepository.save(userMapper.mapToEntity(userDto));
        return userEntity.getUserId();
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public void updateUserName(Long userId, String newUserName) {
        userRepository.updateUserName(userId, newUserName);
    }
}
