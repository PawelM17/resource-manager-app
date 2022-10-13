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

    public UserDto getUser(Long userId) {
        return UserMapper.mapToDto(userRepository.getReferenceById(userId));
    }

    public Long saveUser(UserDto userDto) {
        UserEntity userEntity = userRepository.save(UserMapper.mapToEntity(userDto));
        return userEntity.getId();
    }

    public String deleteUser(Long userId, Long id) {
        if (!isUserValid(id, userId)) {
            return "This operation cannot be performed";
        }
        userRepository.deleteById(userId);
        return "Changes have been successfully saved";
    }

    @Transactional
    public String updateUserName(Long userId, String newUserName, Long id) {
        if (!isUserValid(id, userId)) {
            return "This operation cannot be performed";
        }
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        userEntity.setName(newUserName);
        userEntity.setModifiedDate(new Date());
        return "Changes have been successfully saved";
    }

    public boolean isUserValid(Long id, Long userId) {
        UserEntity userEntity = userRepository.getReferenceById(id);
        return Objects.equals(id, userId) || Objects.equals(userEntity.getUserType(), SUPER_USER);
    }
}
