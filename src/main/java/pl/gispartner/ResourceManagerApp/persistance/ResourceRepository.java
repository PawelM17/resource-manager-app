package pl.gispartner.ResourceManagerApp.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.gispartner.ResourceManagerApp.model.ResourceEntity;


@Repository
public interface ResourceRepository extends JpaRepository<ResourceEntity, Long> {

}
