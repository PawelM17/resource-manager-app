package pl.gispartner.ResourceManagerApp.api;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.gispartner.ResourceManagerApp.model.UserEntity;
import pl.gispartner.ResourceManagerApp.service.UserService;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/save")
    public void saveUser(@RequestBody UserEntity userEntity){
        userService.saveUser(userEntity);
    }
    @DeleteMapping("/delete")
    public void deleteUser (@RequestBody UserEntity userEntity){
        userService.deleteUser(userEntity);
    }
    @PutMapping("/update")
    public void updateUserNickName(@RequestBody UserEntity userEntity){
        userService.updateUserNickName(userEntity.getUserId(), userEntity.getNickName());
    }
}
