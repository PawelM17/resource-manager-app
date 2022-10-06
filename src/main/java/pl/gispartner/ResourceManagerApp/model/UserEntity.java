package pl.gispartner.ResourceManagerApp.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String firstName;
    private String lastName;

//    @OneToMany
//    private List<ResourceEntity> resourceEntityList = new ArrayList<>(); TODO
//    private String creationDate; TODO
//    private String modificationDate; TODO
//    private String userType; TODO

}
