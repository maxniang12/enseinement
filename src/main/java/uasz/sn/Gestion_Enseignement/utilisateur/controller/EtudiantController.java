package uasz.sn.Gestion_Enseignement.utilisateur.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uasz.sn.Gestion_Enseignement.authentification.modele.Utilisateur;
import uasz.sn.Gestion_Enseignement.authentification.service.UtilisateurService;

import java.security.Principal;
@AllArgsConstructor
@Controller
public class EtudiantController {

    private UtilisateurService utilisateurService;

    @RequestMapping(value = "/etudiant/Accueil", method = RequestMethod.GET)
    public String accueil_Etudiant(Model model, Principal principal) {
        Utilisateur utilisateur = utilisateurService.rechercher_Utilisateur(principal.getName());
        model.addAttribute("nom", utilisateur.getNom());
        model.addAttribute("prenom", utilisateur.getPrenom().charAt(0));
        return "template_Etudiant";
    }

    @RequestMapping(value = "/responsableClasse/Accueil", method = RequestMethod.GET)
    public String accueil_ResponsableClasse(Model model, Principal principal) {
        Utilisateur utilisateur = utilisateurService.rechercher_Utilisateur(principal.getName());
        model.addAttribute("nom", utilisateur.getNom());
        model.addAttribute("prenom", utilisateur.getPrenom().charAt(0));
        return "template_ResponsableClasse";
    }



}
