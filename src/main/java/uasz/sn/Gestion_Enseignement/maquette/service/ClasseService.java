package uasz.sn.Gestion_Enseignement.maquette.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uasz.sn.Gestion_Enseignement.maquette.modele.Classe;
import uasz.sn.Gestion_Enseignement.maquette.modele.EC;
import uasz.sn.Gestion_Enseignement.maquette.modele.Formation;
import uasz.sn.Gestion_Enseignement.maquette.repository.ClasseRepository;

import java.util.List;

@Service
@Transactional
public class ClasseService {
    @Autowired
    ClasseRepository classeRepository;

    public Classe AjouterClasse(Classe classe) {
        return classeRepository.save(classe);
    }
    public List<Classe> ListerClasses() {
        return classeRepository.findAll();
    }
    public Classe  ModifierClasse(Classe classe) {
        return classeRepository.save(classe);
    }
    public void ArchiverClasse(Long id) {
        Classe classe = classeRepository.findById(id).get();
        if(classe.isArchive()==true){
            classe.setArchive(false);
        }else {
            classe.setArchive(true);
        }
        classeRepository.save(classe);
    }

    public Classe recherClasse(Long id) {
       Classe classe=classeRepository.findById(id).get();
       return classe;

    }

//    public  List<Classe> listeDesClassDeFormation(Long id){
//        return classeRepository.findFormationById(id);
//    }





}
