package pl.gispartner.ResourceManagerApp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long userId;
    private String name;
    private String firstName;
    private String lastName;
}
