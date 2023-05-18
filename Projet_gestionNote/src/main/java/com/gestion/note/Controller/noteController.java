package com.gestion.note.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.note.Service.ElementService;
import com.gestion.note.Service.noteService;
import com.gestion.note.entities.Element;
import com.gestion.note.entities.Professeur;
import com.gestion.note.entities.br;
import com.gestion.note.entities.note;
@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class noteController {
	       
	@Autowired
	noteService noteService;
	
	@RequestMapping(value="/note-element" , method = RequestMethod.POST)
	  public List<note> ProfElement(@RequestBody Element element) {
		       return noteService.noteElement(element.getNom());
		       
	  }
	  
	  @RequestMapping(value="/note-etd" , method = RequestMethod.POST)
	  public List<br> noteElemenBrs(@RequestBody Element element) {
		       return noteService.noteElemenBrs(element.getNom());
		       
	  }
	  
	  @RequestMapping(value="/SaveNote" , method = RequestMethod.POST)
	  public boolean saveCompte(@RequestBody note note) {
		       return noteService.saveNote(note);
	  } 
}
