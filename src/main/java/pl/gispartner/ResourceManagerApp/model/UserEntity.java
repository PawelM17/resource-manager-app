package pl.gispartner.ResourceManagerApp.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String nickName;
    private String name;
    private String lastName;

//    @OneToMany
//    private List<ResourceEntity> resourceEntityList = new ArrayList<>(); TODO
//    private String creationDate; TODO
//    private String modificationDate; TODO
//    private String userType; TODO

}
