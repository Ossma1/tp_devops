package com.gestion.note.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.note.Service.ElementService;
import com.gestion.note.Service.ProfesseurService;
import com.gestion.note.entities.Compte;
import com.gestion.note.entities.Element;
import com.gestion.note.entities.Module;
import com.gestion.note.entities.Professeur;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class ElementController {

	
	@Autowired
	ElementService elementService;
	@Autowired
	ProfesseurService professeurService;
	
	
	@RequestMapping(value="/Savelement" , method = RequestMethod.POST)
	  public boolean saveCompte(@RequestBody Element element) {
		       return elementService.saveElement(element);
	  } 
	
	
	@RequestMapping(value="/elementValide" , method = RequestMethod.POST)
	  public boolean ValideElement(@RequestBody Element element) {
		       return elementService.ValideElement(element);
	  } 
	
	
	@RequestMapping(value="/Professeur-element" , method = RequestMethod.POST)
	  public List<Element> ProfElement(@RequestBody Compte compte){
		       Professeur prof = professeurService.getProfesseur(compte);
		       return elementService.findProfElement(prof.getId_prof());
		       
	  }
	
	
	@RequestMapping(value="/Module-element" , method = RequestMethod.POST)
	  public List<Element> ModuleElement(@RequestBody Module module) {
		       return elementService.findModuleElement(module.getId_module());
		       
	  } 
	
	@RequestMapping(value="/element-To-prof" , method = RequestMethod.POST)
	@ResponseBody 
	public String affectEleToProf(@RequestParam(value="id_element") Long id_element , @RequestParam(value="id_prof") Long id_prof) {
		       if(elementService.affectEleToprof(id_element, id_prof)) {
		    	    return "Element has alredy an professeur";
		       }
		       return "element affected";
	}
	@GetMapping("/elements")
	  public List<Element> allElement() {
		       return elementService.allElement();
	  }
}
