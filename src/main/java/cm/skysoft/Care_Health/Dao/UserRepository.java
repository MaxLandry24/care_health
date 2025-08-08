package cm.skysoft.Care_Health.Dao;

import cm.skysoft.Care_Health.Entity.UserDomain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserDomain, Long> {
    Optional<UserDomain> findByUsername(String email);
}
