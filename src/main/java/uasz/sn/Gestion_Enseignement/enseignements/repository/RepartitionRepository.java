package uasz.sn.Gestion_Enseignement.enseignements.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uasz.sn.Gestion_Enseignement.enseignements.model.Repartition;

import java.util.List;

public interface RepartitionRepository extends JpaRepository<Repartition, Long> {

    List<Repartition> findByValideTrue();
}
