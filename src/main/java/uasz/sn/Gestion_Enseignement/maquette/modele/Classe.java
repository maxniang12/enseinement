package uasz.sn.Gestion_Enseignement.maquette.modele;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id ;
    @Column(unique=true)
    private String  nomClasse;
    private boolean archive=false;
    @ManyToOne
    private Formation formation;

    public  Boolean isArchive(){
        return archive;
    }

}
