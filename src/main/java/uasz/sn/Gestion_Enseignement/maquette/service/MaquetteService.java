package uasz.sn.Gestion_Enseignement.maquette.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uasz.sn.Gestion_Enseignement.maquette.modele.Classe;
import uasz.sn.Gestion_Enseignement.maquette.modele.Maquette;
import uasz.sn.Gestion_Enseignement.maquette.modele.UE;
import uasz.sn.Gestion_Enseignement.maquette.repository.MaquetteRepository;
import uasz.sn.Gestion_Enseignement.maquette.repository.UERepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class MaquetteService {

    @Autowired
    private MaquetteRepository maquetteRepository;
    @Autowired
    private UERepository ueRepository;
    public List<Maquette> ListerMaquette() {
        return maquetteRepository.findAll();
    }


    public void AjouterMaquette(Maquette maquette, List<Long> ueIds) {
        // Récupérer les UEs par leurs IDs
//        List<UE> ues = ueRepository.findAllById(ueIds);
//        maquette.setUes(ues);
        maquetteRepository.save(maquette);
    }

//    public Maquette AjouterMaquette(Maquette maquette) {
//        return maquetteRepository.save(maquette);
//    }
//public void AjouterMaquette(Maquette maquette ,List<Long> ueIds) {
//    if (maquette.getNomMaquette() == null || maquette.getNomMaquette().isEmpty()) {
//        throw new IllegalArgumentException("Le nom de la maquette est obligatoire.");
//    }
//
//
//    if (maquette.getUE() != null) {
//        maquette.setUE(maquette.getUE().stream()
//                .filter(ue -> ueRepository.existsById(ue.getId()))
//                .collect(Collectors.toList()));
//    }
//
//    maquetteRepository.save(maquette);
//}


    public Maquette RechercherMaquette(Long id) {

//        return maquetteRepository.findMaquetteWithUE(id);

        return  maquetteRepository.findById(id).get();

        // Charge les EC pour chaque UE
//        List<UE> ues = maquette.getUE();
//        if (ues != null && !ues.isEmpty()) {
//            List<UE> uesWithEC = maquetteRepository.findUEWithEC(ues);
//            maquette.setUE(uesWithEC); // Met à jour les UE avec leurs EC
//        }




    }

//        // Charger les UEs avec leurs ECs sans modifier directement l'objet dans la boucle
//        List<UE> ueList = new ArrayList<>();
//        for (UE ue : maquette.getUE()) {
//            ueList.add(ueRepository.findUEWithECsById(ue.getId()));  // Charger chaque UE avec ses ECs
//        }
//        maquette.setUE(ueList);  // Mettre à jour la liste des UEs dans la maquette
//
//        return maquette;




    public Maquette ModifierMaquette(Maquette maquette) {
        return maquetteRepository.save(maquette);

    }

//    public void ActiverMaquette(Long id) {
//        Maquette maquette = maquetteRepository.findById(id).get();
//        if(maquette.isActive()==true) {
//            maquette.setActive(false);
//        }
//        else {
//            maquette.setActive(true);
//        }
//        maquetteRepository.save(maquette);
//
//
//    }

//    public List<Maquette> ListerMaquetteByClasse(Long idc) {
//
//       return maquetteRepository.findClasseById(idc);
//    }
    public List<Maquette> ListerMaquetteByClasse(Classe classe) {
        return maquetteRepository.findMaquettesWithUEsByClasseId(classe); // Utilisation de la nouvelle méthode
    }
}
