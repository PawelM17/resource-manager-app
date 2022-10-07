package pl.gispartner.ResourceManagerApp.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.gispartner.ResourceManagerApp.model.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE UserEntity SET name = :name WHERE id = :id")
    void updateUserName(@Param("id") Long id, @Param("name") String name);
}
