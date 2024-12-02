package uasz.sn.Gestion_Enseignement.maquette.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uasz.sn.Gestion_Enseignement.maquette.modele.Classe;
import uasz.sn.Gestion_Enseignement.maquette.modele.Formation;

public interface ClasseRepository extends JpaRepository<Classe, Long> {
    @Query("select  c from Classe  c where  c.nom =:nom")
    Formation findClasseByName(@Param("nom") String nom);

}
