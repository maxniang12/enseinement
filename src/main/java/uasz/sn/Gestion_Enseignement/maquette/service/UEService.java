package uasz.sn.Gestion_Enseignement.maquette.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uasz.sn.Gestion_Enseignement.maquette.modele.UE;
import uasz.sn.Gestion_Enseignement.maquette.repository.UERepository;
import uasz.sn.Gestion_Enseignement.utilisateur.modele.Enseignant;

import java.util.List;

@Service
@Transactional
public class UEService {
    @Autowired
    private UERepository ueRepository;
    public UE ajouterUE(UE ue) {
        return ueRepository.save(ue);
    }
    public UE rechercherUE(long idUe) {
        return ueRepository.findById(idUe).get();
    }
    public UE modifierUE(UE ue) {
        return ueRepository.save(ue);
    }
    public List<UE> listerlUE() {
        return ueRepository.findAll();
    }
    public void supprimerUe(Long id) {
        ueRepository.deleteById(id);
    }




}
