package uasz.sn.Gestion_Enseignement.authentification.modele;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id ;
    @Column(unique = true)
    private String username;
    @NotNull
    private String password;
    private  String nom;
    private String prenom;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    private Boolean active;
    private String adresse;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles;


    public boolean isActive() {
            return active;
    }
}
