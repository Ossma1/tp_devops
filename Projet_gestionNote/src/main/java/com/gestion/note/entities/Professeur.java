package com.gestion.note.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;

@Entity
public class Professeur {
	 @Id
	 @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id_prof;
	 @Column
	private String nom;
	 @Column
	private String prenom;
	 @Column
	private String specialite;
	
	@OneToOne
	private Compte compte;
	
	

	public Professeur(Long id_prof, String nom, String prenom, String specialite, Compte compte) {
		super();
		this.id_prof = id_prof;
		this.nom = nom;
		this.prenom = prenom;
		this.specialite = specialite;
		this.compte = compte;
		
	}

	public Professeur(String nom, String prenom, String specialite, Compte compte) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.specialite = specialite;
		this.compte = compte;
		
	}

	public Professeur() {
		super();
	}

	public Long getId_prof() {
		return id_prof;
	}

	public void setId_prof(Long id_prof) {
		this.id_prof = id_prof;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	

	@Override
	public String toString() {
		return "Professeur [id_prof=" + id_prof + ", nom=" + nom + ", prenom=" + prenom + ", specialite=" + specialite
				+ ", compte=" + compte + " ]";
	}
	
	
	
	
	
	

}
