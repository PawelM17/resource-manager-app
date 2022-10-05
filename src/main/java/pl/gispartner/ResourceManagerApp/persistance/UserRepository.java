package pl.gispartner.ResourceManagerApp.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.gispartner.ResourceManagerApp.model.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    @Modifying
    @Query(value = "UPDATE UserEntity SET name = :name WHERE userId = :userId")
    void updateUserName(Long userId, String name);
}
