package uasz.sn.Gestion_Enseignement.maquette.controller;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import uasz.sn.Gestion_Enseignement.authentification.modele.Utilisateur;
import uasz.sn.Gestion_Enseignement.authentification.service.UtilisateurService;
import uasz.sn.Gestion_Enseignement.maquette.modele.Classe;
import uasz.sn.Gestion_Enseignement.maquette.service.ClasseService;
import uasz.sn.Gestion_Enseignement.maquette.service.FormationService;

import java.security.Principal;
import java.util.List;

@Controller
@AllArgsConstructor

public class ClasseController {
    private ClasseService classeService;
    private UtilisateurService utilisateurService;
    private FormationService formationService;
@GetMapping("/ChefDepartement/Classe")
    public String Lister_Classe(Model model, Principal principal) {
    Utilisateur utilisateur=utilisateurService.rechercher_Utilisateur(principal.getName());
    model.addAttribute("nom", utilisateur.getNom());
    model.addAttribute("prenom", utilisateur.getPrenom());
    List<Classe> listeClasse = classeService.ListerClasses();
    model.addAttribute("listeClasse", listeClasse);
    return "templateClasse";

}
}
