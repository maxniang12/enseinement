package uasz.sn.Gestion_Enseignement.utilisateur.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uasz.sn.Gestion_Enseignement.utilisateur.modele.Vacataire;
import uasz.sn.Gestion_Enseignement.utilisateur.repository.VacataireRepository;

import java.util.List;

@Service
@Transactional
public class VacataireService {
    @Autowired
    private VacataireRepository vacataireRepository;

    public Vacataire ajouter(Vacataire vacataire) {
        return vacataireRepository.save(vacataire);

    }
    public Vacataire rechercher(Long idVacataire) {
        return  vacataireRepository.findById(idVacataire).get();

    }

    public Vacataire modifier(Vacataire vacataire) {
        return vacataireRepository.save(vacataire);
    }
    public void supprimer(Long idVacataire) {
        vacataireRepository.deleteById(idVacataire);
    }

    public List<Vacataire> lister() {
        return vacataireRepository.findAll();
    }
}
