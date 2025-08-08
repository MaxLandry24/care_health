package cm.skysoft.Care_Health.Dao;

import cm.skysoft.Care_Health.Entity.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MedecinRepository extends JpaRepository<Medecin, Integer> {

    @Query("Select m from Medecin m where m.serviceMedical.nom = :serviceName" )
    List<Medecin> findByServiceName(@Param("serviceName") String serviceName);
}
