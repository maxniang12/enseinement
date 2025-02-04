package uasz.sn.Gestion_Enseignement.maquette.modele;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id ;
    private String  nomClasse;
    private String  niveau;
    private boolean archive=false;
    @ManyToOne
    private Formation formation;

    @OneToMany
    private List<Maquette> maquettes=new ArrayList<>();

    public  Boolean isArchive(){
        return archive;
    }

}
