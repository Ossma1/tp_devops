package com.gestion.note.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import javax.persistence.*;


@Entity
public class Filiere {
	  @Id
	  @GeneratedValue(strategy= GenerationType.IDENTITY)
      private Long id_filiere ;
	  @Column
      private String nom;
	  
	    
	public Filiere() {
		super();
	}
	public Filiere(String nom) {
		super();
		this.nom = nom;
	}
	public Filiere(Long id_filiere, String nom) {
		super();
		this.id_filiere = id_filiere;
		this.nom = nom;
	}
	
	public Long getId_filier() {
		return id_filiere;
	}
	public void setId_filier(Long id_filiere) {
		this.id_filiere = id_filiere;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	@Override
	public String toString() {
		return "Filiere [id_filiere=" + id_filiere + ", nom=" + nom + "]";
	}
	
	
	  
}
