package uasz.sn.Gestion_Enseignement.authentification.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uasz.sn.Gestion_Enseignement.authentification.modele.Utilisateur;
import uasz.sn.Gestion_Enseignement.authentification.service.UtilisateurService;


import java.security.Principal;

@Controller
@AllArgsConstructor
public class UtilisateurController {
    @Autowired
    private UtilisateurService utilisateurService;

    @RequestMapping(value = "/login")
    public String index() {
        return "login";
    }

    @RequestMapping(value = "/")
    public String login(Principal principal) {

        String url="login";
        Utilisateur utilisateur=utilisateurService.rechercher_Utilisateur(principal.getName());

        if(!utilisateur.getActive()){
            url="redirect:/login";
        }
        
        else if(utilisateur.getRoles().get(0).getRole().equals("Permanent")){
            url="redirect:/Permanent/Accueil";

        } else if (utilisateur.getRoles().get(0).getRole().equals("Vacataire")) {
            url="redirect:/Vacataire/Accueil";
            
        }
        else if(utilisateur.getRoles().get(0).getRole().equals("Etudiant")) {
            url="redirect:/etudiant/Accueil";

        }
        else if(utilisateur.getRoles().get(0).getRole().equals("ChefDepartement")) {
            url="redirect:/ChefDepartement/Accueil";
        }
        else if(utilisateur.getRoles().get(0).getRole().equals("ResponsableClasse")) {
            url="redirect:/responsableClasse/Accueil";
        }



        return url;
    }

    @RequestMapping(value = "/logout")
    public String logOutAndRedirectToLoginPage(Authentication authentication, HttpServletRequest request,
                                               HttpServletResponse response) {
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        return "redirect:/login?logout=true";
    }

    @RequestMapping(value = "/profil")
    public String profil_utilisateur(Model model, Principal principal) {
        Utilisateur utilisateur = utilisateurService.rechercher_Utilisateur(principal.getName());
        model.addAttribute("utilisateur", utilisateur);
        model.addAttribute("nom", utilisateur.getNom());
        model.addAttribute("prenom", utilisateur.getPrenom().charAt(0));

        String url= "profil_chefdep";

        if (utilisateur.getRoles().get(0).getRole().equals("Permanent")){

            url="redirect:/Permanent/profile";

        } else if (utilisateur.getRoles().get(0).getRole().equals("Vacataire")) {
            url="redirect:/Vacataire/profile";

        }
        else if(utilisateur.getRoles().get(0).getRole().equals("ChefDepartement")) {
            url="redirect:/ChefDepartement/profile";
        }
        else if(utilisateur.getRoles().get(0).getRole().equals("Etudiant")) {
            url="redirect:/Etudiant/profile";
        }

        return url;
        //spring.jpa.show-sql=true
// yok la git tester

    }


//spring.jpa.show-sql=true
// yok la git tester



}