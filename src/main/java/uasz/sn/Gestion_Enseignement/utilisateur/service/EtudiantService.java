package uasz.sn.Gestion_Enseignement.utilisateur.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uasz.sn.Gestion_Enseignement.utilisateur.modele.Etudiant;
import uasz.sn.Gestion_Enseignement.utilisateur.repository.EtudiantRepository;

import java.util.List;

@Service
@Transactional
public class EtudiantService {
    @Autowired
    private EtudiantRepository etudiantRepository;

    public List<Etudiant> lister() {
        return etudiantRepository.findAll();

    }

    public Etudiant ajouter(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    public Etudiant modifier(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }
    public void  supprimer(Long idEtudiant) {
        etudiantRepository.deleteById(idEtudiant);

    }

    public Etudiant rechercher(Long id) {
        return etudiantRepository.findById(id).get();
    }

}
