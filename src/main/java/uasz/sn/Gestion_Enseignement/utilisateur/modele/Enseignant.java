package uasz.sn.Gestion_Enseignement.utilisateur.modele;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.*;
import uasz.sn.Gestion_Enseignement.authentification.modele.Utilisateur;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "id")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Enseignant extends Utilisateur {
   private String specialite;
   private Boolean archive = false;


   public boolean isArchive() {
      return archive;
   }
}
