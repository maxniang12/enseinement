package uasz.sn.Gestion_Enseignement.utilisateur.modele;

import jakarta.persistence.*;
import lombok.*;
import uasz.sn.Gestion_Enseignement.authentification.modele.Utilisateur;
import uasz.sn.Gestion_Enseignement.enseignements.model.Enseignement;
import uasz.sn.Gestion_Enseignement.enseignements.model.Repartition;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "id")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Enseignant extends Utilisateur {
   private String specialite;
   private Boolean archive = false;

   @OneToMany(mappedBy = "enseignant", cascade = CascadeType.ALL)
   private List<Repartition> repartitions = new ArrayList<>();


   public boolean isArchive() {
      return archive;
   }
}
