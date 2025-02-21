package uasz.sn.Gestion_Enseignement.emplois_Du_Temps.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uasz.sn.Gestion_Enseignement.emplois_Du_Temps.modele.Batiment;
import uasz.sn.Gestion_Enseignement.emplois_Du_Temps.modele.Salle;
import uasz.sn.Gestion_Enseignement.emplois_Du_Temps.repository.SalleRepository;

import java.util.*;

@Service
@Transactional
@AllArgsConstructor
public class SalleService {

    private SalleRepository salleRepository;

    public List<Salle> listerSalle() {
        return salleRepository.findAll();
    }
    public Salle AjouterSalle(Salle salle) {
        return salleRepository.save(salle);
    }
    public Salle recherSalle( Long idSalle) {
        return salleRepository.findById(idSalle).get();
    }

}
