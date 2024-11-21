package uasz.sn.Gestion_Enseignement.utilisateur.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uasz.sn.Gestion_Enseignement.utilisateur.modele.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

}
