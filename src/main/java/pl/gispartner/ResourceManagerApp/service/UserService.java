package pl.gispartner.ResourceManagerApp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.gispartner.ResourceManagerApp.model.UserDto;
import pl.gispartner.ResourceManagerApp.model.UserEntity;
import pl.gispartner.ResourceManagerApp.model.UserMapper;
import pl.gispartner.ResourceManagerApp.persistance.UserRepository;

import java.util.Date;
import java.util.Objects;

import static pl.gispartner.ResourceManagerApp.model.UserType.SUPER_USER;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Long saveUser(UserDto userDto) {
        UserEntity userEntity = userRepository.save(UserMapper.mapToEntity(userDto));
        return userEntity.getId();
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Transactional
    public void updateUserName(Long userId, String newUserName) {
        userRepository.updateUserName(userId, newUserName);
        UserEntity userEntity = userRepository.getReferenceById(userId);
        userEntity.setModifiedDate(new Date());
    }

    public boolean validateUser(Long id, Long userId) {
        UserEntity userEntity = userRepository.getReferenceById(id);
        return Objects.equals(id, userId) || userEntity.getUserType().equals(SUPER_USER);
    }
}
