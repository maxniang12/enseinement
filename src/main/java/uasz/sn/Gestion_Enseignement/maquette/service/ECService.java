package uasz.sn.Gestion_Enseignement.maquette.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uasz.sn.Gestion_Enseignement.maquette.modele.EC;
import uasz.sn.Gestion_Enseignement.maquette.modele.UE;
import uasz.sn.Gestion_Enseignement.maquette.repository.ECRepository;

import java.util.List;

@Service
@Transactional
public class ECService {
    @Autowired
    private ECRepository ecRepository;

    //public List<EC> listerEC(){
       // return  ecRepository.findAll();
   // }

    public  EC  ajouterEC(EC ec){
        return ecRepository.save(ec);
    }
    public EC recherherEC(Long id){
        return ecRepository.findById(id).get();
    }
    public EC modifierEC(EC ec){
        return ecRepository.save(ec);
    }
    public void supprimerEC(Long id){
        ecRepository.deleteById(id);
    }
    public  List<EC> listeDesECDeUe( UE ue){
        return ecRepository.findByUeId(ue);
    }
    public List<EC> listerToutEC(){
        return ecRepository.findAll();
    }
}
