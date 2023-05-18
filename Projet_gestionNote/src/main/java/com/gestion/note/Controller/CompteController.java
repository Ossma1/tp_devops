package com.gestion.note.Controller;

import com.gestion.note.entities.Professeur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.note.Registration.CompteSave;
import com.gestion.note.Service.CompteService;
import com.gestion.note.entities.Admin;
import com.gestion.note.entities.Compte;
@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/compte")
public class CompteController {
       @Autowired
       CompteService compteService;

	  @RequestMapping(value="/generate-prof" , method = RequestMethod.POST)
	  public String generateProfAccount(@RequestBody Professeur professeur) {
		       if (compteService.generateProfesseurCompte(professeur)){
				   return "Account has been created !";
			   }
			   return "Professeur a déjà un compte !";
	  } 
	  
	  
	  @RequestMapping(value="/generate-admin" , method = RequestMethod.POST)
	  public String generateAdminAccount(@RequestBody Admin admin) {
		       if (compteService.generateAdminCompte(admin)){
				   return "Account has been created !";
			   }
			   return "Admin a déjà un compte !";
	  } 
       
}
