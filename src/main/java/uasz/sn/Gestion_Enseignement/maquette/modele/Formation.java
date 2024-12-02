package uasz.sn.Gestion_Enseignement.maquette.modele;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Formation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id ;
    @Column(unique=true)
    private String nomFormation;
    private boolean archive=false;
    @OneToMany
    private List<Classe> classe;

    public  Boolean isArchive(){
        return archive;
    }

}

