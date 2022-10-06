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
public class ResourceEntity extends AuditableBase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

//    @ManyToOne
//    @JoinColumn
//    private UserEntity userEntity;
//    private String resourceType; TODO

}
