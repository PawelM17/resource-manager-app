package pl.gispartner.ResourceManagerApp.model;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@TypeDefs({
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)})
public class ResourceEntity extends AuditableBase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @Enumerated(EnumType.STRING)
    private ResourceType resourceType;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private UserEntity user;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb", length = 2048)
    private String jsonData;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ResourceEntity that = (ResourceEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
