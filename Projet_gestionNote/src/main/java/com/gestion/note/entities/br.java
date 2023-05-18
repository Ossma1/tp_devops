package com.gestion.note.entities;

import java.util.List;

public class br {
    
	private Etudiant e;
	private Element el;
	private List<Modalite> mod;
	private List<Double> notes;
	public Etudiant getE() {
		return e;
	}
	public void setE(Etudiant e) {
		this.e = e;
	}
	public Element getEl() {
		return el;
	}
	public void setEl(Element el) {
		this.el = el;
	}
	public List<Modalite> getMod() {
		return mod;
	}
	public void setMod(List<Modalite> mod) {
		this.mod = mod;
	}
	public List<Double> getNotes() {
		return notes;
	}
	public void setNotes(List<Double> notes) {
		this.notes = notes;
	}
	
}