package uasz.sn.Gestion_Enseignement.maquette.modele;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.*;
import lombok.NoArgsConstructor;

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


    @OneToMany(mappedBy = "ue", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<EC> ec = new ArrayList<>();
    @ManyToMany
    private List<Maquette> maquettes =new ArrayList<>();
}
