package uasz.sn.Gestion_Enseignement;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import uasz.sn.Gestion_Enseignement.authentification.modele.Role;
import uasz.sn.Gestion_Enseignement.authentification.service.UtilisateurService;
import uasz.sn.Gestion_Enseignement.emplois_Du_Temps.modele.Batiment;
import uasz.sn.Gestion_Enseignement.emplois_Du_Temps.modele.Salle;
import uasz.sn.Gestion_Enseignement.emplois_Du_Temps.service.BatimentService;
import uasz.sn.Gestion_Enseignement.emplois_Du_Temps.service.SalleService;
import uasz.sn.Gestion_Enseignement.maquette.modele.Classe;
import uasz.sn.Gestion_Enseignement.maquette.modele.EC;
import uasz.sn.Gestion_Enseignement.maquette.modele.Formation;
import uasz.sn.Gestion_Enseignement.maquette.modele.UE;
import uasz.sn.Gestion_Enseignement.maquette.service.ClasseService;
import uasz.sn.Gestion_Enseignement.maquette.service.FormationService;
import uasz.sn.Gestion_Enseignement.maquette.service.UEService;
import uasz.sn.Gestion_Enseignement.utilisateur.modele.Permanant;
import uasz.sn.Gestion_Enseignement.utilisateur.modele.Vacataire;
import uasz.sn.Gestion_Enseignement.utilisateur.service.EnseignantService;

import java.util.Date;
@AllArgsConstructor
@SpringBootApplication
public class GestionEnseignementApplication implements CommandLineRunner {

	private UtilisateurService utilisateurService;

	private EnseignantService enseignantService;

	private PasswordEncoder passwordEncoder;

	private UEService ueService;

    private FormationService formationService;

	private ClasseService classeService;
	
	private BatimentService batimentService;
	
	private SalleService salleService;

	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public static void main(String[] args) {
		SpringApplication.run(GestionEnseignementApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		Role permanent = utilisateurService.ajouter_Role(new Role("Permanent"));
		Role vacataire = utilisateurService.ajouter_Role(new Role("Vacataire"));
		Role chefdep=utilisateurService.ajouter_Role(new Role("ChefDepartement"));
		String password = passwordEncoder().encode("Passer123");

		Permanant user_1 = new Permanant();
		user_1.setNom("DIOP");
		user_1.setPrenom("Ibrahima");
		user_1.setUsername("idiop@uasz.sn");
		user_1.setPassword(password);
		user_1.setDateCreation(new Date());
		user_1.setActive(true);
		user_1.setSpecialite("Web Semantique");
		user_1.setMatricule("ID2024");
		user_1.setGrade("Professeur");
		enseignantService.ajouter(user_1);
		utilisateurService.ajouter_UtilisateurRole(user_1, permanent);

		Vacataire user_2 = new Vacataire();
		user_2.setNom("MALACK");
		user_2.setPrenom("Camir");
		user_2.setUsername("cmalack@uasz.sn");
		user_2.setPassword(password);
		user_2.setDateCreation(new Date());
		user_2.setActive(true);
		user_2.setSpecialite("Ingénierie de Connaissances");
		user_2.setNiveau("Doctorant");
		enseignantService.ajouter(user_2);
		utilisateurService.ajouter_UtilisateurRole(user_2, vacataire);


		Permanant user_3 = new Permanant();
		user_3.setNom("DIAgne");
		user_3.setPrenom("Serigne");
		user_3.setUsername("sdiagne@uasz.sn");
		user_3.setPassword(password);
		user_3.setDateCreation(new Date());
		user_3.setActive(true);
		user_3.setSpecialite("Base de donnees");
		user_3.setMatricule("SD2024");
		user_3.setGrade("Professeur");
		enseignantService.ajouter(user_3);
		utilisateurService.ajouter_UtilisateurRole(user_3,chefdep);

		UE ue1 = new UE();
		ue1.setCode("NTD123");
		ue1.setLibelle("Reseaux et Telecoms");
		ue1.setCredit(12);
		ue1.setCoeff(8);
		ueService.ajouterUE(ue1);

		UE ue6 = new UE();
		ue6.setCode("NTD126");
		ue6.setLibelle("Genie Logiciel2");
		ue6.setCredit(6);
		ue6.setCoeff(8);
		ueService.ajouterUE(ue6);

		UE ue4=new UE();
		ue4.setCode("NTD456");
		ue4.setLibelle("Humanite et Entreprise");
		ue4.setCredit(3);
		ueService.ajouterUE(ue4);


		UE ue2 = new UE();
		ue2.setCode("NTD124");
		ue2.setLibelle("Algoritme et Programmation");
		ue2.setCredit(8);
		ue2.setCoeff(6);
		ueService.ajouterUE(ue2);


		Formation f=new Formation();
		f.setNomFormation("Ingenierie Informatique");
		f.setDescription("formation en Informatique");
		f.setActive(true);
		f.setArchive(false);
		formationService.ajouterFormation(f);

		Formation f1=new Formation();
		f1.setNomFormation("Mathematique et Informatique");
		f1.setDescription("formation Math et  Informatique");
		f1.setActive(true);
		f1.setArchive(false);
		formationService.ajouterFormation(f1);

		Batiment bat1 = new Batiment();
		bat1.setNombat("batiment Info");
		batimentService.AjouterBatiment(bat1);

		Batiment bat2 = new Batiment();
		bat2.setNombat("batiment E");
		batimentService.AjouterBatiment(bat2);

		

		Salle sal1 = new Salle();
		sal1.setNomsal("Info");
		sal1.setNumerosal("01");
		sal1.setCapacite("70");
		sal1.setBatiment(bat1);
		salleService.AjouterSalle(sal1);
		batimentService.ajouter_SalleBatiment(sal1,bat1);
		Salle sal2 = new Salle();
		sal2.setNomsal("Info");
		sal2.setNumerosal("02");
		sal2.setCapacite("80");
		sal2.setBatiment(bat1);
		salleService.AjouterSalle(sal2);
		batimentService.ajouter_SalleBatiment(sal2,bat1);
		Salle sal3 = new Salle();
		sal3.setNomsal("E");
		sal3.setNumerosal("03");
		sal3.setCapacite("90");
		sal3.setBatiment(bat2);
		salleService.AjouterSalle(sal3);
		batimentService.ajouter_SalleBatiment(sal3,bat2);


	}


	


}




