package uasz.sn.Gestion_Enseignement.emplois_Du_Temps.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uasz.sn.Gestion_Enseignement.authentification.modele.Role;
import uasz.sn.Gestion_Enseignement.authentification.modele.Utilisateur;
import uasz.sn.Gestion_Enseignement.emplois_Du_Temps.modele.Batiment;
import uasz.sn.Gestion_Enseignement.emplois_Du_Temps.modele.Salle;
import uasz.sn.Gestion_Enseignement.emplois_Du_Temps.repository.BatimentRepository;
import uasz.sn.Gestion_Enseignement.emplois_Du_Temps.repository.SalleRepository;

import java.util.*;

@Service
@Transactional
@AllArgsConstructor
public class BatimentService {
    private BatimentRepository batimentRepository;
    private SalleRepository salleRepository;

    public List<Batiment> lister_BAtiment() {
        return batimentRepository.findAll();
    }
    public Batiment AjouterBatiment(Batiment batiment) {

        return batimentRepository.save(batiment);
    }

    public Batiment findBatimentById (Long id) {
        return  batimentRepository.findById(id).get();

    }

    public void ajouter_SalleBatiment(Salle salle , Batiment batiment) {
         Batiment batiment1=batimentRepository.findById(batiment.getId()).get();
        Salle salle1=salleRepository
                .findById(salle.getId()).get();
        batiment1.getSalle().add(salle1);
    }


}
