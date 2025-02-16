package uasz.sn.Gestion_Enseignement.enseignements.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import uasz.sn.Gestion_Enseignement.authentification.modele.Utilisateur;
import uasz.sn.Gestion_Enseignement.authentification.service.UtilisateurService;
import uasz.sn.Gestion_Enseignement.enseignements.model.Enseignement;
import uasz.sn.Gestion_Enseignement.enseignements.model.Repartition;
import uasz.sn.Gestion_Enseignement.enseignements.repository.RepartitionRepository;
import uasz.sn.Gestion_Enseignement.enseignements.service.EnseignementService;
import uasz.sn.Gestion_Enseignement.enseignements.service.RepartitionService;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Controller
@AllArgsConstructor
public class RepartitionController {
    private RepartitionService repartitionService;
    private EnseignementService enseignementService;
    private UtilisateurService utilisateurService;

    @GetMapping("/ChefDepartement/Repartition")
    public String Lister_Repartion(Model model, Principal principal) {
        Utilisateur utilisateur=utilisateurService.rechercher_Utilisateur(principal.getName());
        List<Enseignement> listEnseignement=enseignementService.listerENseignement();
        model.addAttribute("listEnseignement", listEnseignement);
        model.addAttribute("utilisateur", utilisateur);
        model.addAttribute("nom", utilisateur.getNom());
        model.addAttribute("prenom", utilisateur.getPrenom().charAt(0));
//        model.addAttribute("maquettes",maquetteService.ListerMaquette());
        List<Repartition> listReparttion=enseignementService.voirRepartition();
        model.addAttribute("repartitions", listReparttion);
        return "template_repartition";
    }

    @PostMapping("/ChefDepartement/ValiderChoix/")
    public String ValiderChoix(@RequestParam("id")Long id, RedirectAttributes redirectAttributes) {
        repartitionService.validerUnChoix(id);
        redirectAttributes.addFlashAttribute("message", "Le choix a été mis à jour !");
        return "redirect:/ChefDepartement/Repartition";
    }

    @GetMapping("/ChefDepartement/RepartitionValides")
    public String Lister_repartitionValides(Model model, Principal principal){
        Utilisateur utilisateur=utilisateurService.rechercher_Utilisateur(principal.getName());
        List<Enseignement> listEnseignement=enseignementService.listerENseignement();
        model.addAttribute("listEnseignement", listEnseignement);
        model.addAttribute("utilisateur", utilisateur);
        model.addAttribute("nom", utilisateur.getNom());
        model.addAttribute("prenom", utilisateur.getPrenom().charAt(0));
//        model.addAttribute("maquettes",maquetteService.ListerMaquette());
        List<Repartition> listReparttion=repartitionService.ListerRepartitionValides();
        model.addAttribute("repartitionsValides", listReparttion);

        return "template_repartitionValides";

    }


}
