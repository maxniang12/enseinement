package uasz.sn.Gestion_Enseignement.maquette.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uasz.sn.Gestion_Enseignement.maquette.modele.Classe;
import uasz.sn.Gestion_Enseignement.maquette.modele.Maquette;
import uasz.sn.Gestion_Enseignement.maquette.modele.UE;

import java.util.List;

public interface MaquetteRepository extends JpaRepository<Maquette, Long> {
    @Query("SELECT m FROM Maquette m WHERE m.classe= :classe")
    List<Maquette> findMaquettesWithUEsByClasseId(@Param("classe") Classe classe);





}
