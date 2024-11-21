package uasz.sn.Gestion_Enseignement.maquette.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uasz.sn.Gestion_Enseignement.maquette.modele.EC;
import uasz.sn.Gestion_Enseignement.maquette.modele.UE;

import java.util.List;

public interface ECRepository extends JpaRepository<EC, Long> {
    @Query("select  e from  EC e  where  e.code= :code")
    EC findECByCode(@Param("code") String code);

    List<EC> findByUeId(Long ueId);
}
