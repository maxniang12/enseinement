package uasz.sn.Gestion_Enseignement.maquette.controller;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uasz.sn.Gestion_Enseignement.authentification.modele.Utilisateur;
import uasz.sn.Gestion_Enseignement.authentification.service.UtilisateurService;
import uasz.sn.Gestion_Enseignement.maquette.modele.Classe;
import uasz.sn.Gestion_Enseignement.maquette.modele.EC;
import uasz.sn.Gestion_Enseignement.maquette.modele.Formation;
import uasz.sn.Gestion_Enseignement.maquette.service.ClasseService;
import uasz.sn.Gestion_Enseignement.maquette.service.FormationService;

import java.security.Principal;
import java.util.List;

@Controller
@AllArgsConstructor

public class ClasseController {
    private ClasseService classeService;
    private UtilisateurService utilisateurService;
    private FormationService formationService;

@GetMapping("/ChefDepartement/Classe/{id}")
    public String Lister_Classe(Model model, Principal principal, @PathVariable("id") Long id){
    Utilisateur utilisateur=utilisateurService.rechercher_Utilisateur(principal.getName());
    Formation formation= formationService.rechercherFormation(id);
    model.addAttribute("formation", formation);
    model.addAttribute("nom", utilisateur.getNom());
    model.addAttribute("prenom", utilisateur.getPrenom());
    List<Formation> formationList=formationService.ListerFormations();
    model.addAttribute("nomFormation", formation.getNomFormation());
    List<Classe> listeClasse = classeService.listeDesClassDeFormation(formation.getId());
    model.addAttribute("listeClasse", listeClasse);
    model.addAttribute("formationList", formationList);
    return "template_classe";

}
@PostMapping("/ChefDepartement/AjouterClasse/{id}")
    public String Ajouter_Classe( @RequestParam("nomClasse") String nomclasse,@RequestParam("niveau") String niveau,@PathVariable("id") Long fId){
    Formation formation = formationService.rechercherFormation(fId);
    Classe classe = new Classe();
    classe.setNomClasse(nomclasse);
    classe.setNiveau(niveau);
    classe.setFormation(formation);
    classeService.AjouterClasse(classe);
    return "redirect:/ChefDepartement/Classe?id="+fId;

}


//@PostMapping("/ChefDepartement/ModifierClasse")
//    public  String Modiefier_classe(Classe classe){
//    Classe cl=classeService.recherClasse(classe.getId());
//    cl.setNomClasse(classe.getNomClasse());
//    classeService.ModifierClasse(cl);
//    return "redirect:/ChefDepartement/Classe?id="+cl.getFormation().getId();
//
//}
@PostMapping("/ChefDepartement/ModifierClasse/{id}")
public String Modiefier_classe(@PathVariable("id") Long fid, @ModelAttribute Classe classe) {
    Classe cl = classeService.recherClasse(classe.getId());
    cl.setNomClasse(classe.getNomClasse());
    cl.setNiveau(classe.getNiveau());
    classeService.ModifierClasse(cl);
    return "redirect:/ChefDepartement/Classe/" + fid;
}

//@PostMapping("/ChefDepartement/ArchifClasse")
//    public String Archiver_classe(@RequestParam("id") Long id,@RequestParam("clId")Long clId ){
//    classeService.ArchiverClasse(clId);
//    return "redirect:/ChefDepartement/Classe?id="+id;
//}

    @PostMapping("/ChefDepartement/ArchifClasse/{id}/{clId}")
    public String Archiver_classe(@PathVariable("id") Long fid, @PathVariable("clId") Long clId) {
        classeService.ArchiverClasse(clId);
        return "redirect:/ChefDepartement/Classe/" + fid;
    }


}
