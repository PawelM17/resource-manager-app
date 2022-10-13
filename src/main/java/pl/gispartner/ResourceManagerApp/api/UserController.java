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
    public String deleteUser(@PathVariable("userId") Long userId, @RequestHeader Long id) {
        if (userService.validateUser(id, userId)) {
            userService.deleteUser(userId);
            return "Changes have been successfully saved";
        } else {
            return "This operation cannot be performed";
        }
    }

    @PutMapping("/{userId}/name")
    public String updateUserName(@PathVariable("userId") Long userId, @RequestBody String newUserName, @RequestHeader Long id) {
        if (userService.validateUser(id, userId)) {
            userService.updateUserName(userId, newUserName);
            return "Changes have been successfully saved";
        } else {
            return "This operation cannot be performed";
        }
    }
}
