package uasz.sn.Gestion_Enseignement.maquette.modele;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.*;
import lombok.NoArgsConstructor;

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
    private List<UE> UE = new ArrayList<>();
    @ManyToOne
    private Classe classe;



}
