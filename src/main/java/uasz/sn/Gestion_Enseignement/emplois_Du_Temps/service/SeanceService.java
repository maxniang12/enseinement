package uasz.sn.Gestion_Enseignement.emplois_Du_Temps.service;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uasz.sn.Gestion_Enseignement.emplois_Du_Temps.modele.Salle;
import uasz.sn.Gestion_Enseignement.emplois_Du_Temps.modele.Seances;
import uasz.sn.Gestion_Enseignement.emplois_Du_Temps.repository.SeancesRepository;
import uasz.sn.Gestion_Enseignement.enseignements.model.Repartition;
import uasz.sn.Gestion_Enseignement.enseignements.repository.RepartitionRepository;
import uasz.sn.Gestion_Enseignement.enseignements.service.RepartitionService;

import java.util.*;
@Service
@Transactional
@AllArgsConstructor
public class SeanceService {
    private SeancesRepository seancesRepository;
    private RepartitionRepository repartitionRepository;
    private SalleService salleService;
    private RepartitionService repartitionService;

    public List<Seances> ListerSeances(){
        return seancesRepository.findAll();
    }

    public void creerSeance(String jour, String heuredeb,String heurefin, Long repartitionId, Long salleId) {
        Repartition repartition = repartitionService.RechercheRepartition(repartitionId);

        Salle salle = salleService.recherSalle(salleId);

        Seances seance = new Seances();
        seance.setJour(jour);
        seance.setHeuredeb(heuredeb);
        seance.setHeurefin(heurefin);
        seance.setRepartition(repartition);
        seance.setSalle(salle);
        salle.getSeances().add(seance);
        repartition.getSeances().add(seance);
        seancesRepository.save(seance);

    }
}
