package uasz.sn.Gestion_Enseignement.maquette.modele;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.*;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter

public class Maquette {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String semestre;
    @ManyToMany
    private List<UE> UE;
    @ManyToOne
    private Formation formation;

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }

    public List<uasz.sn.Gestion_Enseignement.maquette.modele.UE> getUE() {
        return UE;
    }

    public void setUE(List<uasz.sn.Gestion_Enseignement.maquette.modele.UE> UE) {
        this.UE = UE;
    }

    public String getSemestre() {
        return semestre ;
    }

    public void setSemestre(String nomMaquette) {
        this.semestre = semestre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
