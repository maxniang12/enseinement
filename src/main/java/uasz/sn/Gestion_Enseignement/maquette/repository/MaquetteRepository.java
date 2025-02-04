package uasz.sn.Gestion_Enseignement.maquette.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uasz.sn.Gestion_Enseignement.maquette.modele.Maquette;

import java.util.List;

public interface MaquetteRepository extends JpaRepository<Maquette, Long> {

    List<Maquette> findClasseById(Long Idc);

}
