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
public class ResourceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long resourceId;
    private String name;
//    @ManyToOne
//    @JoinColumn
//    private UserEntity userEntity; TODO
//    private Date creationDate; TODO
//    private Date modificationDate; TODO
//    private String resourceType; TODO

}
