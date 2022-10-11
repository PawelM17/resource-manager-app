package pl.gispartner.ResourceManagerApp.persistance;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.gispartner.ResourceManagerApp.model.ResourceEntity;

@Repository
public interface ResourceRepository extends JpaRepository<ResourceEntity, Long> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE ResourceEntity SET name = :name WHERE id = :id")
    void updateResourceName(@Param("id") Long id, @Param("name") String name);

    @Transactional
    @Modifying
    @Query(value = "UPDATE ResourceEntity SET jsonData = :jsonData WHERE id = :id")
    void updateJsonData(@Param("id") Long id, @Param("jsonData") JsonNode jsonData);

}
