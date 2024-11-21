package uasz.sn.Gestion_Enseignement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import uasz.sn.Gestion_Enseignement.authentification.modele.Role;
import uasz.sn.Gestion_Enseignement.authentification.service.UtilisateurService;
import uasz.sn.Gestion_Enseignement.maquette.modele.EC;
import uasz.sn.Gestion_Enseignement.maquette.modele.UE;
import uasz.sn.Gestion_Enseignement.maquette.service.UEService;
import uasz.sn.Gestion_Enseignement.utilisateur.modele.Permanant;
import uasz.sn.Gestion_Enseignement.utilisateur.modele.Vacataire;
import uasz.sn.Gestion_Enseignement.utilisateur.service.EnseignantService;

import java.util.Date;

@SpringBootApplication
public class GestionEnseignementApplication implements CommandLineRunner {
	@Autowired
	private UtilisateurService utilisateurService;
	@Autowired
	private EnseignantService enseignantService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UEService ueService;

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

	}


}




