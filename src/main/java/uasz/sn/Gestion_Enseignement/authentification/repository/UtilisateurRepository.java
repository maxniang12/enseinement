package uasz.sn.Gestion_Enseignement.authentification.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uasz.sn.Gestion_Enseignement.authentification.modele.Utilisateur;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
   @Query(" select u  from Utilisateur u  where u.username= :use  ")
   Utilisateur findUtilisateurByUsername(@Param("use") String use);
}


