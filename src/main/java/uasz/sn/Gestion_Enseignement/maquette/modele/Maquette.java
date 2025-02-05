package uasz.sn.Gestion_Enseignement.maquette.modele;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.*;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Maquette {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomMaquette;
    private String semestre;
    @ManyToMany
    @BatchSize(size = 10) // Charge les UE par lots de 10
    private List<UE> UE = new ArrayList<>();
    @ManyToOne
    private Classe classe;



}
