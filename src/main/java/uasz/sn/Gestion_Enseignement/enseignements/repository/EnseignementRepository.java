package uasz.sn.Gestion_Enseignement.enseignements.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uasz.sn.Gestion_Enseignement.enseignements.model.Enseignement;

public interface EnseignementRepository extends JpaRepository <Enseignement,Long> {


}
