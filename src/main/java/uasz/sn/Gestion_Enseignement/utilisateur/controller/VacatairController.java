package uasz.sn.Gestion_Enseignement.utilisateur.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uasz.sn.Gestion_Enseignement.authentification.modele.Role;
import uasz.sn.Gestion_Enseignement.authentification.modele.Utilisateur;
import uasz.sn.Gestion_Enseignement.authentification.service.UtilisateurService;
import uasz.sn.Gestion_Enseignement.utilisateur.modele.Vacataire;

import uasz.sn.Gestion_Enseignement.utilisateur.service.EnseignantService;
import uasz.sn.Gestion_Enseignement.utilisateur.service.VacataireService;


import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller

public class VacatairController {
    @Autowired
    private UtilisateurService utilisateurService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    private EnseignantService enseignantService;
    @Autowired
    private VacataireService vacataireService;




    @PostMapping("/ChefDepartement/ajouterVacataire")
    public String ajouter_Vacataire(Vacataire vacataire) {
        String password = passwordEncoder.encode("Passer123");
        vacataire.setPassword(password);
        vacataire.setDateCreation(new Date());
        vacataire.setActive(true);
        Role role=utilisateurService.ajouter_Role(new Role("Vacataire"));
        enseignantService.ajouter(vacataire);
        List<Role> roles=new ArrayList<>();
        roles.add(role);
        vacataire.setRoles(roles);
        enseignantService.ajouter(vacataire);
        return  "redirect:/Chefdepartement/Enseignant";
    }


    @PostMapping("/ChefDepartement/modifierVacataire")
    public String modifier_Vacataire(Vacataire vacataire){
        Vacataire vac_modif=vacataireService.rechercher(vacataire.getId());

        vac_modif.setNom(vacataire.getNom());
        vac_modif.setSpecialite(vacataire.getSpecialite());
        vac_modif.setNiveau(vacataire.getNiveau());
        enseignantService.modifier(vac_modif);
        return "redirect:/Chefdepartement/Enseignant";
    }

    @PostMapping("/ChefDepartement/activerVacataire")
    public  String activer_Vacataire(Long id){
        enseignantService.activer(id);
        return "redirect:/Chefdepartement/Enseignant";
    }

    @PostMapping("/ChefDepartement/archiverVacataire")
    public  String archiver_Vacataire(Long id){
        enseignantService.archiver(id);
        return "redirect:/Chefdepartement/Enseignant";
    }


    @RequestMapping(value = "/Vacataire/Accueil",method = RequestMethod.GET)
    public  String accueill_Vacataire(Model model, Principal principal){
        Utilisateur utilisateur=utilisateurService.rechercher_Utilisateur(principal.getName());
        model.addAttribute("nom",utilisateur.getNom());
        model.addAttribute("prenom",utilisateur.getPrenom().charAt(0));
        return "template_Vacataire";
    }

    @GetMapping("/Vacataire/profile")
    public  String profile_Vacataire(Model model, Principal principal){
        Utilisateur utilisateur=utilisateurService.rechercher_Utilisateur(principal.getName());
        model.addAttribute("nom",utilisateur.getNom());
        model.addAttribute("prenom",utilisateur.getPrenom().charAt(0));
        model.addAttribute("utilisateur",utilisateur);
        return "profil_vacataire";

    }

    @RequestMapping(value = "/Vacataire/modifier" ,method = RequestMethod.POST)
    public String modifier_Utilisateur(Utilisateur utilisateur,Principal principal) {
       Utilisateur use= utilisateurService.rechercher_Utilisateur(principal.getName());
       utilisateur.setNom(use.getNom());
       utilisateur.setPrenom(use.getPrenom());
       utilisateurService.modifierUtilisateur(use);
        return "redirect:/Vacataire/profile";
    }
}
