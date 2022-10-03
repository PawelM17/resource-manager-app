package pl.gispartner.ResourceManagerApp.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.gispartner.ResourceManagerApp.model.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    @Modifying
    @Transactional
    @Query(value = "UPDATE UserEntity SET nickName = :nickName WHERE userId = :userId")
    void updateUserNickName(Long userId, String nickName);
}
