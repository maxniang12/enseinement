package uasz.sn.Gestion_Enseignement.enseignements.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uasz.sn.Gestion_Enseignement.maquette.modele.EC;
import uasz.sn.Gestion_Enseignement.maquette.modele.Maquette;

@Data
@Entity
@NoArgsConstructor @AllArgsConstructor
public class Enseignement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String type;
    @ManyToOne
    private EC ec;
    @ManyToOne
    private Maquette maquette;

}
