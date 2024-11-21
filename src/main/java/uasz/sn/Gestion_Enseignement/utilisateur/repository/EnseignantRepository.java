package uasz.sn.Gestion_Enseignement.utilisateur.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uasz.sn.Gestion_Enseignement.utilisateur.modele.Enseignant;

public interface EnseignantRepository extends JpaRepository<Enseignant, Long> {

}
