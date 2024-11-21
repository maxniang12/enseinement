package uasz.sn.Gestion_Enseignement.authentification.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uasz.sn.Gestion_Enseignement.authentification.modele.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
    @Query("select r from Role r where r.role= :rol")
    Role findByRole(@Param("rol") String rol);
}
