package com.gestion.note.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.note.Repository.ElementRepository;
import com.gestion.note.Repository.noteRepository;
import com.gestion.note.entities.Element;
import com.gestion.note.entities.Etudiant;
import com.gestion.note.entities.Modalite;
import com.gestion.note.entities.br;
import com.gestion.note.entities.note;

@Service
public class noteService {
	
	@Autowired
    noteRepository noteRepository;
	
	
	public noteService(noteRepository noteRepository) {
		super();
		this.noteRepository = noteRepository;
	}


	public List<note> noteElement(String nom) {
		List<note> note=noteRepository.noteElement(nom);
		return note;
	}

	public List<br> noteElemenBrs(String nom) {
		List<note> note=noteRepository.noteElement(nom);
		List<br> br= new ArrayList<>();
		List<Modalite> mod=new ArrayList<>();
		List<Double> notes=new ArrayList<>();
		Etudiant et =new Etudiant();
		Element el=new Element();
		Modalite m= new Modalite();
		List<Long> lr=new ArrayList<>();
		Long e;
		for (note n : note) {
			el=n.getElement();
			et= n.getEtudiant();
			e=n.getEtudiant().getId_etudiant();
			System.out.println(lr.contains(e));
			if(lr.contains(e)==false) {
			for (note n2: note) {
				 if(n2.getEtudiant().getId_etudiant()==e) {
					    m=n2.getModalite();
				        mod.add(m);
				        notes.add(n2.getNote());
				 }
			}
			 lr.add(e);
			 com.gestion.note.entities.br b=new com.gestion.note.entities.br();
			 b.setE(et);
			 b.setEl(el);
			 b.setMod(mod);
			 b.setNotes(notes);
			 br.add(b);
			 mod=new ArrayList<>();;
			 notes=new ArrayList<>();
			 }
			
		}
		return br;
	}
	public boolean saveNote(note note) {
		Modalite m = note.getModalite();
		System.out.println(note.getNote());
		System.out.println(note.getModalite());
		System.out.println(note.getEtudiant());
		System.out.println(note.getEtudiant());
		if(noteRepository.save(note)!=null) {
	    	   return true;
	    }
	    return false;
	}

}
