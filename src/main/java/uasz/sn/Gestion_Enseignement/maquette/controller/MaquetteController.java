package uasz.sn.Gestion_Enseignement.maquette.controller;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import uasz.sn.Gestion_Enseignement.authentification.modele.Utilisateur;
import uasz.sn.Gestion_Enseignement.authentification.service.UtilisateurService;
import uasz.sn.Gestion_Enseignement.maquette.modele.*;
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
private ClasseService classeService;


@GetMapping("/ChefDepartement/Maquette/{id}")
    public String Lister_Maquette(Model model, Principal principal,@PathVariable("id") Long idc) {
    Utilisateur utilisateur=utilisateurService.rechercher_Utilisateur(principal.getName());
    model.addAttribute("nom", utilisateur.getNom());
    model.addAttribute("prenom", utilisateur.getPrenom());
    Classe classe=classeService.recherClasse(idc);
    model.addAttribute("classe",classe);
    List<Maquette> maquettes=maquetteService.ListerMaquetteByClasse(classe);
    model.addAttribute("maquettes",maquettes);
    List<UE> listUes = ueService.listerlUE();
    for (UE ue : listUes) {
        ue.getEcs().size();
    }
    model.addAttribute("listUes",listUes);

    // Charger les UEs associées à chaque maquette
    for (Maquette maquette : maquettes) {
        // Force l'initialisation des UEs
        maquette.getUes().size();
    }



    return "template_maquette1";

}
@PostMapping("/ChefDepartement/AjoutMaquette/{id}")
    public String Ajouter_Maquette(Model model, Principal principal,@PathVariable("id") Long idc,@RequestParam("nomMaquette")String nomMaquette,@RequestParam("semestre") String semestre,@RequestParam("ueIds") List<Long> ueids) {
      Classe classe=classeService.recherClasse(idc);
      List<UE> listUes = ueRepository.findAllById(ueids);
      Maquette maquette=new Maquette();
      maquette.setNomMaquette(nomMaquette);
      maquette.setSemestre(semestre);
      maquette.setClasse(classe);
      maquette.setUes(listUes);
    if (!classe.getMaquettes().contains(maquette)) {
        classe.getMaquettes().add(maquette);
    }
    maquetteService.AjouterMaquette(maquette,ueids);

    for (UE ue : listUes) {
        if (!ue.getMaquettes().contains(maquette)) {
            ue.getMaquettes().add(maquette);
            ueService.ajouterUE(ue);
        }
    }
    classeService.AjouterClasse(classe);
//      classe.getMaquettes().add(maquette);
//      maquetteService.AjouterMaquette(maquette,ueids);
//     classe.getMaquettes().add(maquette);
//        for (UE ue : listUes) {
//            ue.getMaquettes().add(maquette);
//            ueService.ajouterUE(ue);
//        }
//      classeService.AjouterClasse(classe);

      return "redirect:/ChefDepartement/Maquette/{id}";

    }

    @GetMapping("/ChefDepartement/Maquette/{id}/details")
    public String afficherDetailsMaquette(@PathVariable("id") Long id, Model model, Principal principal) {
        Utilisateur utilisateur = utilisateurService.rechercher_Utilisateur(principal.getName());
        model.addAttribute("nom", utilisateur.getNom());
        model.addAttribute("prenom", utilisateur.getPrenom());
//        System.out.println(id);
        // Charge la Maquette avec ses UE et leurs EC
        Maquette maquette = maquetteService.RechercherMaquette(id);
        model.addAttribute("maquette", maquette);
//        List<EC> listeEc=ecService.listeDesECDeUe(maquette.getUes().get(0));
//        model.addAttribute("listeEc", listeEc);
//        System.out.println(maquette.getUes());


        return "details_maquette";
    }

}
