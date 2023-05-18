package com.gestion.note.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.note.Registration.CompteSave;
import com.gestion.note.Repository.CompteRepository;
import com.gestion.note.Repository.ProfRepository;
import com.gestion.note.entities.Compte;
import com.gestion.note.entities.Professeur;

@Service
public class ProfesseurService {
       @Autowired
       ProfRepository profRepository;
       @Autowired
       CompteRepository compteRepository;
	public ProfesseurService(ProfRepository profRepository) {
		super();
		this.profRepository = profRepository;
	}
      
    public List<Professeur> findAllProfesseur(){
    	    return profRepository.findAll();
    }
	public  boolean  saveProf(Professeur professeur){
	    if(profRepository.save(professeur)!=null) {
	    	   return true;
	    }
	    return false;
	}

	public Professeur getProfesseur(Compte compte) {
		Professeur prof = profRepository.findProfesseurbycompte(compte.getIdCompte());
		      return prof;
	}
	
}
