package com.gestion.note.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;

@Entity
public class Element {
	   @Id
	   @GeneratedValue(strategy= GenerationType.IDENTITY)
       private Long id_element;
	   @Column
       private String nom;
       
	   @Column
       private String coeff;
       
       @ManyToOne
       @JoinColumn(name="id_module")
       private Module module;
       
   
       @ManyToOne
       @JoinColumn(name="id_prof")
       private Professeur professeur;
       
       @Column
       private Boolean isValide;

	public Long getId_element() {
		return id_element;
	}

	public void setId_element(Long id_element) {
		this.id_element = id_element;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public Professeur getProfesseur() {
		return professeur;
	}

	public void setProfesseur(Professeur professeur) {
		this.professeur = professeur;
	}

	public Boolean getIsValide() {
		return isValide;
	}

	public void setIsValide(Boolean isValide) {
		this.isValide = isValide;
	}

	public String getCoeff() {
		return coeff;
	}

	public void setCoeff(String coeff) {
		this.coeff = coeff;
	}

	
     
}
