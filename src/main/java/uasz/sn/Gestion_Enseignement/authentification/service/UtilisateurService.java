package uasz.sn.Gestion_Enseignement.authentification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uasz.sn.Gestion_Enseignement.authentification.modele.Role;
import uasz.sn.Gestion_Enseignement.authentification.modele.Utilisateur;
import uasz.sn.Gestion_Enseignement.authentification.repository.RoleRepository;
import uasz.sn.Gestion_Enseignement.authentification.repository.UtilisateurRepository;

@Service
@Transactional
public class UtilisateurService {
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    private RoleRepository roleRepository;

    public Utilisateur ajouter_Utilisateur(Utilisateur utilisateur) {
         utilisateurRepository.save(utilisateur);
         return utilisateur;
    }

    public Role ajouter_Role(Role role) {
      roleRepository.save(role);
       return role;
    }
  public void modifierUtilisateur(Utilisateur utilisateur) {
        Utilisateur user=utilisateurRepository.findUtilisateurByUsername(utilisateur.getUsername());
         if(user!=null) {
             user.setNom(utilisateur.getNom());
             user.setPrenom(utilisateur.getPrenom());


             utilisateurRepository.save(user);
         }

         else{

             throw  new RuntimeException("Utilisateur non trouvable"+utilisateur.getUsername());
         }





  }

    public void ajouter_UtilisateurRole(Utilisateur utilisateur, Role role) {
        Utilisateur  user= utilisateurRepository.findUtilisateurByUsername(utilisateur.getUsername());
        Role profil= roleRepository.findByRole(role.getRole());
        user.getRoles().add(profil);
    }
    public  Utilisateur rechercher_Utilisateur(String username) {
        Utilisateur utilisateur = utilisateurRepository.findUtilisateurByUsername(username);
        return utilisateur;

    }

}
