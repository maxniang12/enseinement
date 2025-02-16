package uasz.sn.Gestion_Enseignement.enseignements.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uasz.sn.Gestion_Enseignement.enseignements.model.Enseignement;
import uasz.sn.Gestion_Enseignement.enseignements.model.Repartition;
import uasz.sn.Gestion_Enseignement.enseignements.model.TypeService;
import uasz.sn.Gestion_Enseignement.enseignements.repository.EnseignementRepository;
import uasz.sn.Gestion_Enseignement.enseignements.repository.RepartitionRepository;
import uasz.sn.Gestion_Enseignement.maquette.modele.EC;
import uasz.sn.Gestion_Enseignement.maquette.modele.Maquette;
import uasz.sn.Gestion_Enseignement.maquette.modele.UE;
import uasz.sn.Gestion_Enseignement.maquette.repository.MaquetteRepository;
import uasz.sn.Gestion_Enseignement.utilisateur.modele.Enseignant;
import uasz.sn.Gestion_Enseignement.utilisateur.repository.EnseignantRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
@AllArgsConstructor

public class EnseignementService {
    private EnseignementRepository enseignementRepository;
    private RepartitionRepository repartitionRepository;
    private MaquetteRepository maquetteRepository;
    private EnseignantRepository enseignantRepository;


    public List<Enseignement> listerENseignement() {
        return enseignementRepository.findAll();

    }

    public void ajouterEnseignement() {
        List<Maquette> maquettes = maquetteRepository.findAll();

        for (Maquette maquette : maquettes) {
            for( UE ue:maquette.getUes()){
                for(EC ec: ue.getEcs()){
                    if(ec.getCm()>0){
                       Enseignement enseignementCM = new Enseignement();
                       enseignementCM.setTypeService(TypeService.cm);
                       enseignementCM.setMaquette(maquette);
                       enseignementCM.setEc(ec);
                       enseignementRepository.save(enseignementCM);
                    }

                    if(ec.getTd()>0){
                        Enseignement enseignementTD = new Enseignement();
                        enseignementTD.setTypeService(TypeService.td);
                        enseignementTD.setMaquette(maquette);
                        enseignementTD.setEc(ec);
                        enseignementRepository.save(enseignementTD);
                    }
                    if(ec.getTp()>0){
                        Enseignement enseignementTP = new Enseignement();
                        enseignementTP.setTypeService(TypeService.tp);
                        enseignementTP.setMaquette(maquette);
                        enseignementTP.setEc(ec);
                        enseignementRepository.save(enseignementTP);
                    }

                }
            }
        }
    }

    public void choisirEnseignement(Long einseignementId,Long enseignantId) {
        Enseignement enseignement=enseignementRepository.findById(einseignementId).get();
        Enseignant enseignant=enseignantRepository.findById(enseignantId).get();
        Repartition repartition=new Repartition();
        repartition.setEnseignement(enseignement);
        repartition.setEnseignant(enseignant);
        repartition.setDate(LocalDate.now());
        repartitionRepository.save(repartition);

    }
    public List<Repartition> voirRepartition() {
        return repartitionRepository.findAll();
    }

    public Boolean enseignantADejasChoisir( Long enseignantId,Long enseignementId,List<Repartition> repartitions){

        return repartitions.stream()
                .anyMatch(r -> r.getEnseignant() != null && r.getEnseignement() != null &&
                        Objects.equals(r.getEnseignant().getId(), enseignantId) &&
                        Objects.equals(r.getEnseignement().getId(), enseignementId));


    }

}
