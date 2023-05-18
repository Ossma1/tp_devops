package com.gestion.note.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class note {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id_note;
	@ManyToOne
    @JoinColumn(name = "id_etudiant")
    private Etudiant etudiant;

	@ManyToOne
    @JoinColumn(name = "id_modalite")
    private Modalite modalite;

	@ManyToOne
    @JoinColumn(name = "id_element")
    private Element element;
	
	private double note;
	
	private Boolean isAbsent;
	
	private String coeff ; 

	public Long getId_note() {
		return id_note;
	}

	public void setId_note(Long id_note) {
		this.id_note = id_note;
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public Modalite getModalite() {
		return modalite;
	}

	public void setModalite(Modalite modalite) {
		this.modalite = modalite;
	}

	public Element getElement() {
		return element;
	}

	public void setElement(Element element) {
		this.element = element;
	}

	public double getNote() {
		return note;
	}

	public void setNote(double note) {
		this.note = note;
	}

	public Boolean getIsAbsent() {
		return isAbsent;
	}

	public void setIsAbsent(Boolean isAbsent) {
		this.isAbsent = isAbsent;
	}

	public String getCoeff() {
		return coeff;
	}

	public void setCoeff(String coeff) {
		this.coeff = coeff;
	}
	
	
	
	
}
