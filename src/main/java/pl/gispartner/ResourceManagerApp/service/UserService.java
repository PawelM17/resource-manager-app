package pl.gispartner.ResourceManagerApp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.gispartner.ResourceManagerApp.exceptions.UserAuthorityMissingException;
import pl.gispartner.ResourceManagerApp.exceptions.UserNotFoundException;
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
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User is not found for id = " + userId));
        return UserMapper.mapToDto(userEntity);
    }

    public Long saveUser(UserDto userDto) {
        UserEntity userEntity = userRepository.save(UserMapper.mapToEntity(userDto));
        return userEntity.getId();
    }

    public String deleteUser(Long userId, Long id) {
        if (!isUserValid(userId, id)) {
            throw new UserAuthorityMissingException("This operation cannot be performed - lack of authority");
        }
        userRepository.deleteById(userId);
        return "Changes have been successfully saved";
    }

    @Transactional
    public String updateUserName(Long userId, String newUserName, Long id) {
        if (!isUserValid(userId, id)) {
            throw new UserAuthorityMissingException("This operation cannot be performed - lack of authority");
        }
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User is not found for id = " + userId));
        userEntity.setName(newUserName);
        userEntity.setModifiedDate(new Date());
        return "Changes have been successfully saved";
    }

    public boolean isUserValid(Long userId, Long id) {
        if (!userRepository.existsById(userId)) {
            throw new UserNotFoundException("User is not found for id = " + userId);
        }
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User is not found for id = " + id));
        return Objects.equals(userId, id) || Objects.equals(userEntity.getUserType(), SUPER_USER);
    }
}
