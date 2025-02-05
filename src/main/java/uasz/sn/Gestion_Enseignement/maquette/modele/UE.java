package uasz.sn.Gestion_Enseignement.maquette.modele;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.*;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;

import java.util.*;

@Data
@AllArgsConstructor @NoArgsConstructor
@Entity


public class UE {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id ;
    private String libelle;
    private String code;
    //private String description;
    private int coeff;
    private int credit;


    @OneToMany
    @BatchSize(size = 10) // Charge les EC par lots de 10
    private List<EC> EC = new ArrayList<>();
    @ManyToMany
    private List<Maquette> maquettes =new ArrayList<>();
}
