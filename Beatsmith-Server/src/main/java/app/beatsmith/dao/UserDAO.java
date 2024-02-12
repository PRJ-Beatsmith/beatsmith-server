package app.beatsmith.dao;

import app.beatsmith.entity.db.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<UserEntity, Long> {
    boolean existsByUsername(String username);

}
