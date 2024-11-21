package uasz.sn.Gestion_Enseignement.maquette.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uasz.sn.Gestion_Enseignement.maquette.modele.UE;

public interface UERepository extends JpaRepository<UE, Long> {
    @Query("select  u from  UE u  where  u.code= :code")
    UE findUEByCode(@Param("code") String code);
}
