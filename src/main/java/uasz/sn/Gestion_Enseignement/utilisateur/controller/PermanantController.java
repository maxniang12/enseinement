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
import uasz.sn.Gestion_Enseignement.utilisateur.modele.Permanant;
import uasz.sn.Gestion_Enseignement.utilisateur.service.EnseignantService;
import uasz.sn.Gestion_Enseignement.utilisateur.service.PermanantService;

import java.security.Principal;
import java.util.*;

@Controller
public class PermanantController {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    private UtilisateurService utilisateurService;
    @Autowired
    private EnseignantService enseignantService;
    @Autowired
    private PermanantService permanantService;

    @PostMapping("/ChefDepartement/ajouterPermanent")
    public String ajouter_Permanent(Permanant permanant) {
        String password = passwordEncoder.encode("Passer123");
        permanant.setPassword(password);
        permanant.setDateCreation(new Date());
        permanant.setActive(true);
        Role role=utilisateurService.ajouter_Role(new Role("Permanent"));
        enseignantService.ajouter(permanant);
        List<Role> roles=new ArrayList<>();
        roles.add(role);
        permanant.setRoles(roles);
        enseignantService.ajouter(permanant);
        return  "redirect:/Chefdepartement/Enseignant";
    }

    @RequestMapping(value = "/Permanent/Accueil", method = RequestMethod.GET)
    public String accueill_permanent(Model model , Principal principal) {
        Utilisateur utilisateur=utilisateurService.rechercher_Utilisateur(principal.getName());
        model.addAttribute("nom", utilisateur.getNom());
        model.addAttribute("prenom", utilisateur.getPrenom().charAt(0));
        return "template_Permanent";
    }

    @RequestMapping(value ="/ChefDepartement/Accueil",method = RequestMethod.GET)
    public String accueill_chefDepartement(Model model , Principal principal) {
        Utilisateur utilisateur=utilisateurService.rechercher_Utilisateur(principal.getName());
        model.addAttribute("nom", utilisateur.getNom());
        model.addAttribute("prenom", utilisateur.getPrenom().charAt(0));
        return "template_chefDepartement";

    }

    @PostMapping("/ChefDepartement/modifierPermanent")
    public String modifier_Permanent(Permanant permanant){
        Permanant per_modif=permanantService.rechercher(permanant.getId());
        per_modif.setMatricule(permanant.getMatricule());
        per_modif.setNom(permanant.getNom());
        per_modif.setSpecialite(permanant.getSpecialite());
        per_modif.setGrade(permanant.getGrade());
        enseignantService.modifier(per_modif);
        return "redirect:/Chefdepartement/Enseignant";
    }

    @PostMapping("/ChefDepartement/activerPermanent")
    public  String activer_Permanent(Long id){
        enseignantService.activer(id);
        return "redirect:/Chefdepartement/Enseignant";
    }

    @PostMapping("/ChefDepartement/archiverPermanent")
    public  String archiver_Permanent(Long id){
        enseignantService.archiver(id);
        return "redirect:/Chefdepartement/Enseignant";
    }

@GetMapping("/Permanent/profile")
    public String profile_Permanent(Model model, Principal principal) {
        Utilisateur utilisateur=utilisateurService.rechercher_Utilisateur(principal.getName());
        model.addAttribute("utilisateur", utilisateur);
        model.addAttribute("nom", utilisateur.getNom());
        model.addAttribute("prenom", utilisateur.getPrenom().charAt(0));
        return "profil_permanent";

}

    @GetMapping("/ChefDepartement/profile")
    public String profile_Chefdep(Model model, Principal principal) {
        Utilisateur utilisateur=utilisateurService.rechercher_Utilisateur(principal.getName());
        model.addAttribute("utilisateur", utilisateur);
        model.addAttribute("nom", utilisateur.getNom());
        model.addAttribute("prenom", utilisateur.getPrenom().charAt(0));
        return "profil_chefdep";

    }
    @RequestMapping(value = "/ChefDepartement/modifier" ,method = RequestMethod.POST)
    public String modifier_Utilisateur(Utilisateur utilisateur,Principal principal) {
        Utilisateur use= utilisateurService.rechercher_Utilisateur(principal.getName());
        utilisateur.setNom(use.getNom());
        utilisateur.setPrenom(use.getPrenom());
        utilisateurService.modifierUtilisateur(use);
        return "redirect:/ChefDepartement/profile";
    }







}

