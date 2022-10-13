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

    @GetMapping("/{userId}")
    public UserDto getUser(@PathVariable("userId") Long userId) {
        return userService.getUser(userId);
    }

    @PostMapping
    public Long saveUser(@RequestBody UserDto userDto) {
        return userService.saveUser(userDto);
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable("userId") Long userId, @RequestHeader Long id) {
        return userService.deleteUser(userId, id);
    }

    @PutMapping("/{userId}/name")
    public String updateUserName(@PathVariable("userId") Long userId, @RequestBody String newUserName, @RequestHeader Long id) {
        return userService.updateUserName(userId, newUserName, id);
    }
}
