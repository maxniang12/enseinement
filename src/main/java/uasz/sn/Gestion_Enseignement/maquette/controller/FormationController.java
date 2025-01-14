package uasz.sn.Gestion_Enseignement.maquette.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import uasz.sn.Gestion_Enseignement.authentification.modele.Utilisateur;
import uasz.sn.Gestion_Enseignement.authentification.service.UtilisateurService;
import uasz.sn.Gestion_Enseignement.maquette.modele.Formation;
import uasz.sn.Gestion_Enseignement.maquette.service.ClasseService;
import uasz.sn.Gestion_Enseignement.maquette.service.FormationService;
import java.security.Principal;
import java.util.List;

@Controller
@AllArgsConstructor
public class FormationController {
    private FormationService formationService;
    private ClasseService classeService;
    private UtilisateurService utilisateurService;

    @GetMapping("/ChefDepartement/Formation")
    public String Lister_Formation(Model model, Principal principal) {
        Utilisateur utilisateur=utilisateurService.rechercher_Utilisateur(principal.getName());
        List<Formation> formationList=formationService.ListerFormations();
        model.addAttribute("formationList", formationList);
        model.addAttribute("nom", utilisateur.getNom());
        model.addAttribute("prenom", utilisateur.getPrenom().charAt(0));
        return "formation";
    }

    @PostMapping("/ChefDepartement/AjouterFormation")
    public String Ajouter_Formation(Formation formation) {
        formationService.ajouterFormation(formation);
        return "redirect:/ChefDepartement/Formation";
    }

    @PostMapping("/ChefDepartement/ModifierFormation")
    public String Modifier_Formation(Formation formation) {
        formationService.ModifierFormation(formation);
        return "redirect:/ChefDepartement/Formation";
    }
    @PostMapping("/ChefDepartement/ArchifFormation")
        public String Archif_Formation(Long id ) {
            formationService.ArchiverFormation(id);
            return "redirect:/ChefDepartement/Formation";
    }
}