package pl.gispartner.app.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.gispartner.app.model.ResourceEntity;


@Repository
public interface ResourceRepository extends JpaRepository<ResourceEntity, Long> {

}
