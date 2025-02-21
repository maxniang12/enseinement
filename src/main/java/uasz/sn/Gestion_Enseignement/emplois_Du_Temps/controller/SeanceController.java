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
    public String Ajouter_Seance (@RequestParam("jour") String jour, @RequestParam("heure") String heuredeb,@RequestParam("repartition") Long repartitionId , @RequestParam("salle") Long salleId) {
         seanceService.creerSeance(jour, heuredeb,repartitionId, salleId);
        return "redirect:/ChefDepartement/Seances";

    }

    @GetMapping("/ChefDepartement/Emplois_Temps")
    public String Lister_Emplois_Temps (Model model, Principal principal) {
        Utilisateur utilisateur= utilisateurService.rechercher_Utilisateur(principal.getName());
        List<Seances> seancesList=seanceService.ListerSeances();
        model.addAttribute("seances", seancesList);
        model.addAttribute("nom", utilisateur.getNom());
        model.addAttribute("prenom", utilisateur.getPrenom().charAt(0));
        List<String> jours = Arrays.asList("Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi");
        List<String> heures = Arrays.asList("8h - 9h","8h - 10h","10h - 12h","13h - 15h","15h - 17h");

        model.addAttribute("jours", jours);
        model.addAttribute("heures", heures);
        return "template_emplois";

    }

    @GetMapping("/Permanent/Emplois_Temps")
    public String Lister_Emplois_TempsVac (Model model, Principal principal) {
        Utilisateur utilisateur= utilisateurService.rechercher_Utilisateur(principal.getName());
        List<Seances> seancesList=seanceService.ListerSeances();
        model.addAttribute("seances", seancesList);
        model.addAttribute("nom", utilisateur.getNom());
        model.addAttribute("prenom", utilisateur.getPrenom().charAt(0));
        List<String> jours = Arrays.asList("Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi");
        List<String> heures = Arrays.asList("8h - 9h","8h - 10h","10h - 12h","13h - 15h","15h - 17h");

        model.addAttribute("jours", jours);
        model.addAttribute("heures", heures);
        return "template_emploisPerm";

    }

    @GetMapping("/Vacataire/Emplois_Temps")
    public String Lister_Emplois_TempsPer (Model model, Principal principal) {
        Utilisateur utilisateur= utilisateurService.rechercher_Utilisateur(principal.getName());
        List<Seances> seancesList=seanceService.ListerSeances();
        model.addAttribute("seances", seancesList);
        model.addAttribute("nom", utilisateur.getNom());
        model.addAttribute("prenom", utilisateur.getPrenom().charAt(0));
        List<String> jours = Arrays.asList("Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi");
        List<String> heures = Arrays.asList("8h - 9h","8h - 10h","10h - 12h","13h - 15h","15h - 17h");

        model.addAttribute("jours", jours);
        model.addAttribute("heures", heures);
        return "template_emploisVac";

    }

}
