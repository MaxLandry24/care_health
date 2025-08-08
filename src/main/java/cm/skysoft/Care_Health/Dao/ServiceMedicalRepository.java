package cm.skysoft.Care_Health.Dao;

import cm.skysoft.Care_Health.Entity.ServiceMedical;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ServiceMedicalRepository extends JpaRepository<ServiceMedical, Integer> {

    Optional<ServiceMedical> findByNom(String nom);

}
