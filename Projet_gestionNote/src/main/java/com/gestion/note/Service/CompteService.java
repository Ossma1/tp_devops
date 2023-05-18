package com.gestion.note.Service;

import com.gestion.note.Repository.ProfRepository;
import com.gestion.note.entities.CompteType;
import com.gestion.note.entities.Professeur;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.note.Registration.CompteSave;
import com.gestion.note.Repository.AdminRepository;
import com.gestion.note.Repository.CompteRepository;
import com.gestion.note.entities.Admin;
import com.gestion.note.entities.Compte;

@Service
public class CompteService {
     @Autowired
     CompteRepository compteRepository;

	 @Autowired
	 ProfRepository profRepository;
	 
	 @Autowired
	 AdminRepository adminRepository;


	public CompteService(CompteRepository compteRepository) {
		super();
		this.compteRepository = compteRepository;
	}


	public boolean  generateProfesseurCompte(Professeur professeur){
		Random r = new Random();
		professeur = profRepository.getReferenceById(professeur.getId_prof());
		if (professeur.getCompte() != null) return false;
		Compte compte = new Compte();
		compte.setEmail(professeur.getNom()+".@Ensakh.com");
		compte.setPassword("A"+r.nextInt(10000));
		compte.setCompteType(CompteType.PROFFESSEUR);
		compte = compteRepository.save(compte);
		professeur.setCompte(compte);
		profRepository.save(professeur);
		return true;
	}


	public boolean generateAdminCompte(Admin admin) {
		admin = adminRepository.getReferenceById(admin.getId_admin());
		if (admin.getCompte() != null) return false;
		Compte compte = new Compte();
		compte.setEmail(admin.getNom()+".@ecole.com");
		compte.setPassword("ddd");
		compte.setCompteType(CompteType.ADMIN);
		compte = compteRepository.save(compte);
		admin.setCompte(compte);
		adminRepository.save(admin);
		return true;
	}
	
	public Compte findCompte(Compte compte) {
		compte = compteRepository.findCompteByEmailAndPassword(compte.getEmail(), compte.getPassword());
		return compte;
	}


}
