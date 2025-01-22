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
    private String nomFormation;
    private  String niveauFormation;
    private Boolean archive=false;
    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean active=true;
    @OneToMany
    private List<Maquette> maquettes;

    public  Boolean isArchive(){
        return archive;
    }
    public boolean isActive() {
        return active;
    }

}

