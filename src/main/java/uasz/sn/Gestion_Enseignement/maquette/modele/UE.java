package uasz.sn.Gestion_Enseignement.maquette.modele;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.*;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
    private List<EC> EC = new ArrayList<>();
    @ManyToMany
    private List<Maquette> maquettes =new ArrayList<>();
}
