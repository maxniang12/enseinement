package uasz.sn.Gestion_Enseignement.maquette.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import uasz.sn.Gestion_Enseignement.authentification.modele.Utilisateur;
import uasz.sn.Gestion_Enseignement.authentification.service.UtilisateurService;
import uasz.sn.Gestion_Enseignement.maquette.modele.EC;
import uasz.sn.Gestion_Enseignement.maquette.modele.UE;
import uasz.sn.Gestion_Enseignement.maquette.service.ECService;
import uasz.sn.Gestion_Enseignement.maquette.service.UEService;
import java.security.Principal;
import java.util.List;

@Controller
@AllArgsConstructor
public class ECController {

    @Autowired
    private ECService ecService;
    @Autowired
    private UEService ueService;

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping("/ChefDepartement/EC")
    public String lister_EC(Model model , Principal principal , @RequestParam("id") Long id) {
        UE ue=ueService.rechercherUE(id);
        model.addAttribute("code", ue.getCode());
        model.addAttribute("libelle", ue.getLibelle());
        model.addAttribute("ue",ue);
        Utilisateur user=utilisateurService.rechercher_Utilisateur(principal.getName());
        model.addAttribute("nom", user.getNom());
        model.addAttribute("prenom", user.getPrenom());
        List<UE>  listeUE=ueService.listerlUE();
        List<EC> listeEc=ecService.listeDesECDeUe(ue.getId());
        model.addAttribute("listeUE", listeUE);
        model.addAttribute("listeEc", listeEc);
        return "ue_details";

    }

    @PostMapping("/ChefDepartement/AjouterEC")
    public String ajouterEC(@RequestParam("libelle") String libelle,  @RequestParam("code") String code, @RequestParam("coeff") int coeff, @RequestParam("tp") int tp,
                            @RequestParam("td") int td,
                            @RequestParam("cm") int cm,
                            @RequestParam("tpe") int tpe,
                            @RequestParam("ue") Long ueId) {


        UE ue=ueService.rechercherUE(ueId);
        EC  ec=new EC();
        ec.setLibelle(libelle);
        ec.setCode(code);
        ec.setCoeff(coeff);
        ec.setTp(tp);
        ec.setTpe(tpe);
        ec.setTd(td);
        ec.setCm(cm);
        ec.setUe(ue);
        ecService.ajouterEC(ec);
        return  "redirect:/ChefDepartement/EC?id="+ec.getUe().getId();
    }

    @PostMapping("/ChefDepartement/ModifierEC")
    public String modifier_EC(EC ec) {
        EC ecs=ecService.recherherEC(ec.getId());

        ecs.setLibelle(ec.getLibelle());
        ecs.setCoeff(ec.getCoeff());
        ecs.setCode(ec.getCode());
        ecs.setTp(ec.getTp());
        ecs.setTpe(ec.getTpe());
        ecs.setTd(ec.getTd());
        ecs.setCm(ec.getCm());
        ecService.modifierEC(ecs);

       return  "redirect:/ChefDepartement/EC?id="+ecs.getUe().getId();
    }

    @PostMapping("/ChefDepartement/SupprimerEC")
    public String supprimer_EC( @RequestParam("id") Long id ,EC ec) {
        ecService.recherherEC(ec.getId());
       ecService.supprimerEC(id);

        return  "redirect:/ChefDepartement/EC?id="+id;

    }












}
