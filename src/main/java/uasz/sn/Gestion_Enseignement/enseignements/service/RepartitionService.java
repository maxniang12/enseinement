package uasz.sn.Gestion_Enseignement.enseignements.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uasz.sn.Gestion_Enseignement.enseignements.model.Repartition;
import uasz.sn.Gestion_Enseignement.enseignements.repository.RepartitionRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class RepartitionService {
    private RepartitionRepository repartitionRepository;

    public void validerUnChoix(Long id) {
        Optional<Repartition> repartitionOpt = repartitionRepository.findById(id);
        if (repartitionOpt.isPresent()) {
            Repartition repartition = repartitionOpt.get();
            repartition.setValide(!repartition.isValide()); // Inverse l'état de validation
            repartitionRepository.save(repartition);
        }
}
 public List<Repartition>  ListerRepartitionValides() {
        return repartitionRepository.findByValideTrue();
 }

 public Repartition RechercheRepartition(Long id) {
        Optional<Repartition> repartitionOpt = repartitionRepository.findById(id);
        return repartitionOpt.orElse(null);
 }
}
