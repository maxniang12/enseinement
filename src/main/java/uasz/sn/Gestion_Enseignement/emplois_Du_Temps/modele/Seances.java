package uasz.sn.Gestion_Enseignement.emplois_Du_Temps.modele;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uasz.sn.Gestion_Enseignement.enseignements.model.Repartition;

@AllArgsConstructor @NoArgsConstructor
@Data
@Entity
public class Seances {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String jour;
    private String heuredeb;
    private String heurefin;
    @ManyToOne
    private Repartition repartition;
    @ManyToOne
    private Salle salle;
}
