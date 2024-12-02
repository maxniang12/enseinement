package uasz.sn.Gestion_Enseignement.maquette.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uasz.sn.Gestion_Enseignement.maquette.modele.Classe;
import uasz.sn.Gestion_Enseignement.maquette.modele.Formation;
import uasz.sn.Gestion_Enseignement.maquette.repository.FormationRepository;

import java.util.List;

@Service
@Transactional
public class FormationService {
    @Autowired
    private FormationRepository formationRepository;

    public Formation rechercherFormation(Long id) {
        Formation formation=formationRepository.findById(id).get();
        return formation;

    }

    public Formation ajouterFormation(Formation formation) {
        return formationRepository.save(formation);
    }
    public List<Formation> ListerFormations() {
        return formationRepository.findAll();
    }
    public  Formation ModifierFormation(Formation formation) {
        return formationRepository.save(formation);
    }
    public void ArchiverFormation (Long id){
        Formation formation =formationRepository.findById(id).get();
        if(formation.isArchive()==true){
            formation.setArchive(false);
        }else {
            formation.setArchive(true);
        }

        formationRepository.save(formation);
    }


}
