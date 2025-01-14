package uasz.sn.Gestion_Enseignement.maquette.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uasz.sn.Gestion_Enseignement.maquette.modele.Classe;
import uasz.sn.Gestion_Enseignement.maquette.modele.EC;
import uasz.sn.Gestion_Enseignement.maquette.modele.Formation;

import java.util.List;

public interface ClasseRepository extends JpaRepository<Classe, Long> {
   /*
    @Query("select  c from Classe  c where  c.nomClasse =:nom")
    Formation findClasseByName(@Param("nom") String nom);
    */

    List<Classe> findFormationById(Long fId);

}
