package pl.gispartner.ResourceManagerApp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.gispartner.ResourceManagerApp.model.UserEntity;
import pl.gispartner.ResourceManagerApp.persistance.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void saveUser (UserEntity user){
        userRepository.save(new UserEntity(user.getUserId(), user.getNickName(), user.getName(), user.getLastName()));
    }
    public void deleteUser (UserEntity user){
        userRepository.delete(user);
    }
    public void updateUserNickName(Long userId, String newUserNickName){
        userRepository.updateUserNickName(userId, newUserNickName);
    }
}
