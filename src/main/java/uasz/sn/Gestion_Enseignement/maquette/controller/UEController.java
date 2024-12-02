package uasz.sn.Gestion_Enseignement.maquette.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import uasz.sn.Gestion_Enseignement.authentification.modele.Utilisateur;
import uasz.sn.Gestion_Enseignement.authentification.service.UtilisateurService;
import uasz.sn.Gestion_Enseignement.maquette.modele.UE;
import uasz.sn.Gestion_Enseignement.maquette.service.ECService;
import uasz.sn.Gestion_Enseignement.maquette.service.UEService;
import java.security.Principal;
import java.util.List;

@Controller
@AllArgsConstructor
public class UEController {

    private UEService ueService;

    private UtilisateurService utilisateurService;

    private ECService ecService;

    @GetMapping("/ChefDepartement/UE")
    public String lister_UE(Model model ,Principal principal) {
        Utilisateur use=utilisateurService.rechercher_Utilisateur(principal.getName());
        model.addAttribute("nom", use.getNom());
        model.addAttribute("prenom", use.getPrenom().charAt(0));
     List<UE> listeUE=ueService.listerlUE();

     model.addAttribute("listeUE", listeUE);
     return "template_ue";

    }

    @PostMapping("/ChefDepartement/AjouterUE")
    public String ajouterUE(UE ue) {
        ueService.ajouterUE(ue);
     return  "redirect:/ChefDepartement/UE";
    }



    @PostMapping("/ChefDepartement/ModifierUE")
    public String modifierUE(UE ue) {
        UE use=ueService.rechercherUE(ue.getId());
        use.setLibelle(ue.getLibelle());
        use.setCoeff(ue.getCoeff());
        use.setCode(ue.getCode());
        use.setCredit(ue.getCredit());
        ueService.modifierUE(use);
        return  "redirect:/ChefDepartement/UE";
    }

   @PostMapping("/ChefDepartement/SupprimerUE")
    public String supprimerUE(Long id) {
        ueService.supprimerUe(id);

        return  "redirect:/ChefDepartement/UE";

   }




}
