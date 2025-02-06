package uasz.sn.Gestion_Enseignement.maquette.modele;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EC {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id ;
    private String libelle;
    private String code;
   // private String description;
    private int coeff;
    private int cm;
    private int tp;
    private int td;
    private int tpe;
    @ManyToOne
    private UE ue;
}

