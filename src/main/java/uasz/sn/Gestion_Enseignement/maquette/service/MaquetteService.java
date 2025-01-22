package uasz.sn.Gestion_Enseignement.maquette.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uasz.sn.Gestion_Enseignement.maquette.modele.Maquette;
import uasz.sn.Gestion_Enseignement.maquette.repository.MaquetteRepository;

import java.util.List;

@Service
@Transactional
public class MaquetteService {
    @Autowired
    private MaquetteRepository maquetteRepository;
    public List<Maquette> ListerMaquette() {
        return maquetteRepository.findAll();
    }

    public Maquette AjouterMaquette(Maquette maquette) {
        return maquetteRepository.save(maquette);
    }

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

    public List<Maquette> ListerMaquetteByFormation(Long idf) {

       return maquetteRepository.findFormationById(idf);
    }
}
