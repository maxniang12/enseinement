package uasz.sn.Gestion_Enseignement.emplois_Du_Temps.modele;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor @NoArgsConstructor
@Data
@Entity
public class Batiment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombat;
    @OneToMany
    private List<Salle> salle = new ArrayList<>();

}
