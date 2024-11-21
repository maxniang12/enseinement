package uasz.sn.Gestion_Enseignement.utilisateur.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uasz.sn.Gestion_Enseignement.authentification.modele.Utilisateur;
import uasz.sn.Gestion_Enseignement.authentification.service.UtilisateurService;
import uasz.sn.Gestion_Enseignement.utilisateur.modele.Permanant;
import uasz.sn.Gestion_Enseignement.utilisateur.modele.Vacataire;
import uasz.sn.Gestion_Enseignement.utilisateur.service.PermanantService;
import uasz.sn.Gestion_Enseignement.utilisateur.service.VacataireService;

import java.security.Principal;
import java.util.*;

@Controller
@AllArgsConstructor
public class EnseignantController {
    @Autowired
    private UtilisateurService utilisateurService;
    @Autowired
    private PermanantService permanantService;
    @Autowired
    private VacataireService vacataireService;

    @GetMapping("/Chefdepartement/Enseignant")
    public  String chefdepartement_enseignant(Model model, Principal principal){
       List<Permanant> permanents=permanantService.lister();
       model.addAttribute("permanents", permanents);
       List<Vacataire> vacataires=vacataireService.lister();
       model.addAttribute("vacataires", vacataires);
        Utilisateur utilisateur=utilisateurService.rechercher_Utilisateur(principal.getName());
        model.addAttribute("nom", utilisateur.getNom());
        model.addAttribute("prenom", utilisateur.getPrenom().charAt(0));
        return "chefDepartement_Enseignant";

    }


}


