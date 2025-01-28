package uasz.sn.Gestion_Enseignement.maquette.modele;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.*;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@AllArgsConstructor @NoArgsConstructor
@Entity
@Setter
@Getter

public class UE {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id ;
    private String libelle;
    private String code;
    //private String description;
    private int coeff;
    private int credit;



    public List<uasz.sn.Gestion_Enseignement.maquette.modele.EC> getEC() {
        return EC;
    }

    public void setEC(List<uasz.sn.Gestion_Enseignement.maquette.modele.EC> EC) {
        this.EC = EC;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getCoeff() {
        return coeff;
    }

    public void setCoeff(int coeff) {
        this.coeff = coeff;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public List<Maquette> getMaquettes() {
        return maquettes;
    }

    public void setMaquettes(List<Maquette> maquettes) {
        this.maquettes = maquettes;
    }

    @OneToMany
    private List<EC> EC;
    @ManyToMany
    private List<Maquette> maquettes;
}
