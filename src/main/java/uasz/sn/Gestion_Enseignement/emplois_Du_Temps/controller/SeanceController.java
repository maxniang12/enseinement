package uasz.sn.Gestion_Enseignement.emplois_Du_Temps.controller;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import uasz.sn.Gestion_Enseignement.authentification.modele.Utilisateur;
import uasz.sn.Gestion_Enseignement.authentification.service.UtilisateurService;
import uasz.sn.Gestion_Enseignement.emplois_Du_Temps.modele.Salle;
import uasz.sn.Gestion_Enseignement.emplois_Du_Temps.modele.Seances;
import uasz.sn.Gestion_Enseignement.emplois_Du_Temps.service.SalleService;
import uasz.sn.Gestion_Enseignement.emplois_Du_Temps.service.SeanceService;
import uasz.sn.Gestion_Enseignement.enseignements.model.Repartition;
import uasz.sn.Gestion_Enseignement.enseignements.repository.RepartitionRepository;
import uasz.sn.Gestion_Enseignement.enseignements.service.RepartitionService;

import java.security.Principal;
import java.util.*;
@Controller
@AllArgsConstructor
public class SeanceController {
    private UtilisateurService utilisateurService;
    private SeanceService seanceService;
    private RepartitionService repartitionService;
    private SalleService salleService;
    private RepartitionRepository repartitionRepository;



    @GetMapping("/ChefDepartement/Seances")
    public String Lister_Seances (Model model, Principal principal) {
        Utilisateur utilisteur= utilisateurService.rechercher_Utilisateur(principal.getName());
        List<Seances> seancesList=seanceService.ListerSeances();
        List<Repartition> repartitions=repartitionService.ListerRepartitionValides();
        List<Salle> salles=salleService.listerSalle();
        model.addAttribute("seances", seancesList);
        model.addAttribute("repartitions", repartitions);
        model.addAttribute("salles", salles);
        model.addAttribute("utilisateur", utilisteur);
        model.addAttribute("nom", utilisteur.getNom());
        model.addAttribute("prenom", utilisteur.getPrenom().charAt(0));
        return "template_seances";

    }

    @PostMapping("/ChefDepartement/AjouterSeance")
    public String Ajouter_Seance (@RequestParam("jour") String jour, @RequestParam("heuredeb") String heuredeb, @RequestParam("heurefin") String heurefin,@RequestParam("repartition") Long repartitionId , @RequestParam("salle") Long salleId) {
         seanceService.creerSeance(jour, heuredeb, heurefin, repartitionId, salleId);
        return "redirect:/ChefDepartement/Seances";

    }

}
