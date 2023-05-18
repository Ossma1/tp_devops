package com.gestion.note.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.note.Repository.ElementRepository;
import com.gestion.note.Repository.ProfRepository;
import com.gestion.note.entities.Element;
import com.gestion.note.entities.Professeur;

@Service
public class ElementService {
    @Autowired
    ElementRepository elementRepository;
    
    @Autowired
    ProfRepository profRepository;
    
	public ElementService(ElementRepository elementRepository) {
		super();
		this.elementRepository = elementRepository;
	}
    
	
	public List<Element> findAllElement(){
	    return elementRepository.findAll();
     }
	public List<Element> findProfElement(Long id_prof){
		List<Element> elements=elementRepository.findProfElement(id_prof);
		return elements;
         }
	
	public boolean affectEleToprof(Long id_element,Long id_prof) {
		    Element  element = elementRepository.getReferenceById(id_element); 
		    if(element.getProfesseur() == null) { 
		    	Professeur professeur = profRepository.getReferenceById(id_prof);
		        element.setProfesseur(professeur);
		        elementRepository.save(element);     
		        return false;
		        }
		    System.out.println(element.getProfesseur().getNom());
		    return true;
     }


	public List<Element> findModuleElement(Long id_module) {
		List<Element> elements=elementRepository.findModuleElement(id_module);
		return elements;
	}


	public boolean saveElement(Element element) {
		if(elementRepository.save(element)!=null) {
	    	   return true;
	    }
	    return false;
	}


	public boolean ValideElement(Element element) {
		Element elementv = elementRepository.getReferenceById(element.getId_element());
		elementv.setIsValide(true);
		elementRepository.save(elementv);
		return true;
	}
	public List<Element> allElement() {		
	    return elementRepository.findAll();
}
}
