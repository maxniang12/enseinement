package uasz.sn.Gestion_Enseignement.enseignements.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import uasz.sn.Gestion_Enseignement.authentification.modele.Utilisateur;
import uasz.sn.Gestion_Enseignement.authentification.service.UtilisateurService;
import uasz.sn.Gestion_Enseignement.enseignements.model.Enseignement;
import uasz.sn.Gestion_Enseignement.enseignements.model.Repartition;
import uasz.sn.Gestion_Enseignement.enseignements.service.EnseignementService;
import uasz.sn.Gestion_Enseignement.maquette.service.MaquetteService;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@AllArgsConstructor
public class EnseignementController {
    private EnseignementService enseignementService;
    private UtilisateurService utilisateurService;
    private MaquetteService maquetteService;

    @GetMapping("/ChefDepartement/EnseignementLister")
    public String listerEnseignement(Model model, Principal principal) {
        Utilisateur utilisateur=utilisateurService.rechercher_Utilisateur(principal.getName());
        List<Enseignement> listEnseignement=enseignementService.listerENseignement();
        model.addAttribute("listEnseignement", listEnseignement);
        model.addAttribute("utilisateur", utilisateur);
        model.addAttribute("nom", utilisateur.getNom());
        model.addAttribute("prenom", utilisateur.getPrenom().charAt(0));
        model.addAttribute("maquettes",maquetteService.ListerMaquette());
        List<Repartition> listReparttion=enseignementService.voirRepartition();
        model.addAttribute("repartitions",listReparttion);
        Map<Long,Boolean> choixEfectue=new HashMap<>();

        for (Enseignement en: listEnseignement) {
            choixEfectue.put(en.getId(),enseignementService.enseignantADejasChoisir(utilisateur.getId(), en.getId(),listReparttion));
        }

        model.addAttribute("choixEfectue", choixEfectue);

        return "template_enseignement";
    }

    @GetMapping("/Permanent/EnseignementLister")
    public String listerEnseignementPourPermanent(Model model, Principal principal) {
        Utilisateur utilisateur1=utilisateurService.rechercher_Utilisateur(principal.getName());
        List<Enseignement> listEnseignement=enseignementService.listerENseignement();
        List<Repartition> listRepartition=enseignementService.voirRepartition();
        model.addAttribute("listEnseignement", listEnseignement);
        model.addAttribute("utilisateur", utilisateur1);
        model.addAttribute("nom", utilisateur1.getNom());
        model.addAttribute("prenom", utilisateur1.getPrenom().charAt(0));
        model.addAttribute("maquettes",maquetteService.ListerMaquette());
        model.addAttribute("repartitions",listRepartition);

        Map<Long,Boolean> choixEfectue=new HashMap<>();

        for (Enseignement en: listEnseignement) {
            choixEfectue.put(en.getId(),enseignementService.enseignantADejasChoisir(utilisateur1.getId(), en.getId(),listRepartition));
        }

        model.addAttribute("choixEfectue", choixEfectue);

        return "template_enseignPerm";
    }

    @GetMapping("/Vacataire/EnseignementLister")
    public String listerEnseignementPourVacataire(Model model, Principal principal) {
        Utilisateur utilisateur2=utilisateurService.rechercher_Utilisateur(principal.getName());
        List<Enseignement> listEnseignement=enseignementService.listerENseignement();
        List<Repartition> listRepartition=enseignementService.voirRepartition();
        model.addAttribute("listEnseignement", listEnseignement);
        model.addAttribute("utilisateur", utilisateur2);
        model.addAttribute("nom", utilisateur2.getNom());
        model.addAttribute("prenom", utilisateur2.getPrenom().charAt(0));
        model.addAttribute("maquettes",maquetteService.ListerMaquette());
        model.addAttribute("repartitions",listRepartition);

        Map<Long,Boolean> choixEfectue=new HashMap<>();

        for (Enseignement en: listEnseignement) {
            choixEfectue.put(en.getId(),enseignementService.enseignantADejasChoisir(utilisateur2.getId(), en.getId(),listRepartition));
        }

        model.addAttribute("choixEfectue", choixEfectue);

        return "template_enseignVaca";
    }

    @PostMapping("/ChefDepartement/AjoutEnseignement")
    public String AjouterEnseignement() {
        enseignementService.ajouterEnseignement();
        return "redirect:/ChefDepartement/EnseignementLister";
    }

    @PostMapping("/ChefDepartement/ChoisirEnseignement")
    public String ChoisirEnseignement(@RequestParam("enseignantId") Long enseignantId,@RequestParam("enseignementId") Long enseignementId) {
          enseignementService.choisirEnseignement(enseignementId,enseignantId);
          return "redirect:/ChefDepartement/EnseignementLister";
    }

    @PostMapping("/Vacataire/ChoisirEnseignement")
    public String ChoisirEnseignementPourVac(@RequestParam("enseignantId") Long enseignantId,@RequestParam("enseignementId") Long enseignementId) {
        enseignementService.choisirEnseignement(enseignementId,enseignantId);
        return "redirect:/Vacataire/EnseignementLister";
    }

    @PostMapping("/Permanent/ChoisirEnseignement")
    public String ChoisirEnseignementPourPer(@RequestParam("enseignantId") Long enseignantId,@RequestParam("enseignementId") Long enseignementId){
        enseignementService.choisirEnseignement(enseignementId,enseignantId);
        return "redirect:/Permanent/EnseignementLister";
    }
}