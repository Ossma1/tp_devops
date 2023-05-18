package com.gestion.note.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.note.Service.ModuleService;
import com.gestion.note.entities.Element;
import com.gestion.note.entities.Filiere;
import com.gestion.note.entities.Module;
import com.gestion.note.entities.Professeur;

@RestController
public class ModuleController {
   
	@Autowired
	ModuleService moduleService;
	
	@RequestMapping(value="/findModuleFiliere" , method = RequestMethod.POST)
	  public List<Module> findModuleFiliere(@RequestBody Long filiere) {
		    
		       return moduleService.findModuleFiliere(filiere);
		       
	  }
}
