package uasz.sn.Gestion_Enseignement.maquette.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uasz.sn.Gestion_Enseignement.maquette.modele.Formation;

public interface FormationRepository extends JpaRepository<Formation, Long> {


/*
@Query("select  f  from  Formation  f where  f.nomFormation =:nomFormation")
    Formation findFormationByNom(@Param("nomFormtion") String nomFormation);
 */

}
