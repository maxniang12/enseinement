package uasz.sn.Gestion_Enseignement.maquette.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uasz.sn.Gestion_Enseignement.maquette.modele.UE;

import java.util.List;

public interface UERepository extends JpaRepository<UE, Long> {
//    @Query("select  u from  UE u  where  u.code= :code")
//    UE findUEByCode(@Param("code") String code);

 @Query("SELECT DISTINCT u FROM UE u LEFT JOIN FETCH u.ecs")
 List<UE> findAllWithECs();
 //

// @Query("SELECT u FROM UE u JOIN FETCH u.EC WHERE u.id = :ueId")
// UE findUEWithECsById(@Param("ueId") Long ueId);
//@Query("SELECT u FROM UE u JOIN FETCH u.ecs WHERE u.id = :ueId")
//UE findUEWithECsById(@Param("ueId") Long ueId);

}
