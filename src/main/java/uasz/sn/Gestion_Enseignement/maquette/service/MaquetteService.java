package uasz.sn.Gestion_Enseignement.maquette.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uasz.sn.Gestion_Enseignement.maquette.modele.Maquette;
import uasz.sn.Gestion_Enseignement.maquette.modele.UE;
import uasz.sn.Gestion_Enseignement.maquette.repository.MaquetteRepository;
import uasz.sn.Gestion_Enseignement.maquette.repository.UERepository;

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
        List<UE> ues = ueRepository.findAllById(ueIds);
        maquette.setUE(ues);
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
        return  maquetteRepository.findById(id).get();

    }

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

    public List<Maquette> ListerMaquetteByClasse(Long idc) {

       return maquetteRepository.findClasseById(idc);
    }
}
