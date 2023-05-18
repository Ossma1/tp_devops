package com.gestion.note.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.note.Registration.CompteSave;
import com.gestion.note.Service.CompteService;
import com.gestion.note.Service.ElementService;
import com.gestion.note.Service.ProfesseurService;
import com.gestion.note.entities.Compte;
import com.gestion.note.entities.Element;
import com.gestion.note.entities.Professeur;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class ProfesseurController {
	@Autowired
    ProfesseurService professeurService;
	

	  @RequestMapping(value="/professeur" , method = RequestMethod.POST)
	  public boolean saveCompte(@RequestBody Professeur professeur) {
		       return professeurService.saveProf(professeur);
	  } 
	  
	  
	  @GetMapping("/professeurs")
	  public List<Professeur> Profs(){
		  return professeurService.findAllProfesseur();
	        
	        
	  } 
	  @RequestMapping(value="/Espace-professeur" , method = RequestMethod.POST)
	  public Professeur getProfesseurbyid(@RequestBody Compte compte) {
		       return professeurService.getProfesseur(compte);
	  }
		
	  
}
