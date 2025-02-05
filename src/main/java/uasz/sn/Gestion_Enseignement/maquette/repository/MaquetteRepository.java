package uasz.sn.Gestion_Enseignement.maquette.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uasz.sn.Gestion_Enseignement.maquette.modele.Maquette;

import java.util.List;

public interface MaquetteRepository extends JpaRepository<Maquette, Long> {

//    List<Maquette> findClasseById(Long Idc);

    @Query("SELECT m FROM Maquette m JOIN FETCH m.UE WHERE m.classe.id = :classeId")
    List<Maquette> findMaquettesWithUEsByClasseId(@Param("classeId") Long classeId);

    @Query("SELECT m FROM Maquette m JOIN FETCH m.UE ue JOIN FETCH ue.ec WHERE m.id = :id")
    Maquette findMaquetteWithUEAndEC(@Param("id") Long id);



}
