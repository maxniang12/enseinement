package uasz.sn.Gestion_Enseignement.emplois_Du_Temps.controller;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import uasz.sn.Gestion_Enseignement.authentification.modele.Utilisateur;
import uasz.sn.Gestion_Enseignement.authentification.service.UtilisateurService;
import uasz.sn.Gestion_Enseignement.emplois_Du_Temps.service.BatimentService;
import uasz.sn.Gestion_Enseignement.emplois_Du_Temps.service.SalleService;

import java.security.Principal;
import java.util.*;
@Controller
@AllArgsConstructor
public class SalleController {
    private SalleService salleService;
    private UtilisateurService utilisateurService;
    private BatimentService batimentService;
//    @GetMapping("/ChefDepartement/Salle/{id}")
//    public String chefDepartement(@PathVariable("id") Long id, Model model, Principal principal) {
//        Utilisateur utilisateur=utilisateurService.rechercher_Utilisateur(principal.getName());
//        model.addAttribute("utilisateur", utilisateur);
//        model.addAttribute("nom", utilisateur.getNom());
//        model.addAttribute("prenom", utilisateur.getPrenom().charAt(0));
//
//        return "template_salle";



}
