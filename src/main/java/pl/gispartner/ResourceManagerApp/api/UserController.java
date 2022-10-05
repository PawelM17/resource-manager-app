package pl.gispartner.ResourceManagerApp.api;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.gispartner.ResourceManagerApp.model.UserDto;
import pl.gispartner.ResourceManagerApp.service.UserService;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public Long saveUser(@RequestBody UserDto userDto) {
        return userService.saveUser(userDto);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
    }

    @PutMapping("/{userId}")
    public void updateUserName(@PathVariable("userId") Long userId, @RequestBody String newUserName) {
        userService.updateUserName(userId, newUserName);
    }
}
