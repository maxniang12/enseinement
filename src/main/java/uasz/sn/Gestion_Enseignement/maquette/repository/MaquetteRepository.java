package uasz.sn.Gestion_Enseignement.maquette.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uasz.sn.Gestion_Enseignement.maquette.modele.Maquette;
import uasz.sn.Gestion_Enseignement.maquette.modele.UE;

import java.util.List;

public interface MaquetteRepository extends JpaRepository<Maquette, Long> {

//    List<Maquette> findClasseById(Long Idc);

    @Query("SELECT m FROM Maquette m JOIN FETCH m.UE WHERE m.classe.id = :classeId")
    List<Maquette> findMaquettesWithUEsByClasseId(@Param("classeId") Long classeId);

    // Charge une Maquette avec ses UE
    @Query("SELECT m FROM Maquette m JOIN FETCH m.UE WHERE m.id = :id")
    Maquette findMaquetteWithUE(@Param("id") Long id);

    // Charge les UE avec leurs EC
    @Query("SELECT ue FROM UE ue JOIN FETCH ue.EC WHERE ue IN :ues")
    List<UE> findUEWithEC(@Param("ues") List<UE> ues);



}
