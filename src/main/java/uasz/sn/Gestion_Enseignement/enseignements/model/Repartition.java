package uasz.sn.Gestion_Enseignement.enseignements.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uasz.sn.Gestion_Enseignement.emplois_Du_Temps.modele.Seances;
import uasz.sn.Gestion_Enseignement.utilisateur.modele.Enseignant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Repartition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean valide = false;
    @ManyToOne
    @JoinColumn(name = "enseignement_id", nullable = false)
    private Enseignement enseignement;

    @ManyToOne
    @JoinColumn(name = "enseignant_id", nullable = false)
    private Enseignant enseignant;

    @Column(name = "date")
    private LocalDate date;

    @OneToMany
    private List<Seances> seances=new ArrayList<>();

    public Boolean isValide(){
        return valide;
    }

}
