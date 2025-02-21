package uasz.sn.Gestion_Enseignement.emplois_Du_Temps.modele;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@AllArgsConstructor @NoArgsConstructor
@Data
@Entity
public class Salle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomsal;
    private String numerosal;
    private String capacite;
    @ManyToOne
    private Batiment batiment;
    @OneToMany
    private List<Seances> seances=new ArrayList<>();



}
