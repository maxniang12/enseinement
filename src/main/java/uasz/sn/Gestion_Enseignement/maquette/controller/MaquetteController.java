package uasz.sn.Gestion_Enseignement.maquette.controller;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import uasz.sn.Gestion_Enseignement.authentification.modele.Utilisateur;
import uasz.sn.Gestion_Enseignement.authentification.service.UtilisateurService;
import uasz.sn.Gestion_Enseignement.maquette.modele.Classe;
import uasz.sn.Gestion_Enseignement.maquette.modele.Formation;
import uasz.sn.Gestion_Enseignement.maquette.modele.Maquette;
import uasz.sn.Gestion_Enseignement.maquette.modele.UE;
import uasz.sn.Gestion_Enseignement.maquette.repository.UERepository;
import uasz.sn.Gestion_Enseignement.maquette.service.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
@AllArgsConstructor
public class MaquetteController {
private MaquetteService maquetteService;
private UtilisateurService utilisateurService;
private FormationService formationService;
private UEService ueService;
private ECService ecService;
private UERepository ueRepository;



//@GetMapping("/ChefDepartement/Maquette")
//    public String lister_Maquette(Model model, Principal principal, @RequestParam("id") Long idformation) {
//    Utilisateur use=utilisateurService.rechercher_Utilisateur(principal.getName());
//    Formation formation= formationService.rechercherFormation(idformation);
//
//    List<Maquette> listeMaquette=maquetteService.ListerMaquetteByFormation(formation.getId());
//
//    List<Formation> formationList=formationService.ListerFormations();
//
//    List<UE> listeUE=ueService.listerlUE();
//
//
//    model.addAttribute("nom",use.getNom());
//    model.addAttribute("prenom",use.getPrenom());
//    model.addAttribute("listeMaquette",listeMaquette);
//    model.addAttribute("formation",formation);
//    model.addAttribute("idformation",idformation);
//    model.addAttribute("listeUE",listeUE);
//    model.addAttribute("formationList",formationList);
//    return "template_maquette";
//
//}

    @GetMapping("/ChefDepartement/Maquette")
    public String lister_Maquette(Model model, Principal principal, @RequestParam("id") Long idformation) {
        Utilisateur use = utilisateurService.rechercher_Utilisateur(principal.getName());
        Formation formation = formationService.rechercherFormation(idformation);
        List<Maquette> listeMaquette = maquetteService.ListerMaquetteByFormation(formation.getId());
        List<Formation> formationList = formationService.ListerFormations();
        List<UE> listeUE = ueService.listerlUE();

        // Ajouter les données au modèle
        model.addAttribute("nom", use.getNom());
        model.addAttribute("prenom", use.getPrenom());
        model.addAttribute("listeMaquette", listeMaquette);
        model.addAttribute("formation", formation);
        model.addAttribute("idformation", idformation);
        model.addAttribute("listeUE", listeUE);
        model.addAttribute("formationList", formationList);

        // Ajouter un exemple de maquette si nécessaire
        if (!listeMaquette.isEmpty()) {
            model.addAttribute("maquette", listeMaquette.get(0)); // Exemple avec la première maquette
        } else {
            model.addAttribute("maquette", null); // Evite une erreur si aucune maquette
        }

        return "template_maquette";
    }



    @PostMapping("/ChefDepartement/AjouterMaquette")
    public String Ajouter_Maquette( Model model,@RequestParam("nomMaquette") String nomMaquette,@RequestParam("ueIds") List<Long> ueIds,@RequestParam("idf") Long formationId
          ){
        Formation formation=formationService.rechercherFormation(formationId);
        Maquette maquette=new Maquette();
        maquette.setNomMaquette(nomMaquette);
        List<UE> selectedUEs = ueRepository.findAllById(ueIds);
        maquette.setUE(selectedUEs);
       maquette.setFormation(formation);
       maquetteService.AjouterMaquette(maquette,ueIds);
    model.addAttribute("maquette", maquette);
    model.addAttribute("selectedUEs", selectedUEs);
    model.addAttribute("Maquette", maquetteService.ListerMaquetteByFormation(formation.getId()));


    return "template_maquette";

}








}
