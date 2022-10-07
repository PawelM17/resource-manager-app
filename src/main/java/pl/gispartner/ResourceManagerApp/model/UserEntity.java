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
public class UserEntity extends AuditableBase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String firstName;
    private String lastName;
    @Enumerated(EnumType.STRING)
    private UserType userType;

//    @OneToMany(targetEntity = ResourceEntity.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id", referencedColumnName = "id")
//    private List<ResourceEntity> resourceEntityList; TODO

}
