package uasz.sn.Gestion_Enseignement.enseignements.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uasz.sn.Gestion_Enseignement.maquette.modele.EC;
import uasz.sn.Gestion_Enseignement.maquette.modele.Maquette;
import uasz.sn.Gestion_Enseignement.utilisateur.modele.Enseignant;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor @AllArgsConstructor
public class Enseignement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private  TypeService typeService;

    @ManyToOne
    private EC ec;
    @ManyToOne
    private Maquette maquette;

    @OneToMany(mappedBy = "enseignement", cascade = CascadeType.ALL)
    private List<Repartition> repartitions = new ArrayList<>();
}
