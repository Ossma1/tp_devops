package com.gestion.note.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Module {
	 @Id
	 @GeneratedValue(strategy= GenerationType.IDENTITY)
	 private Long id_module;
	 @Column
	 private String nom;
	 
	 @ManyToOne
	 @JoinColumn(name="id_filiere")
	 Filiere filiere;
	
	 @Enumerated(EnumType.STRING)
	    @Column
	    private Semestre semestre;


	public Long getId_module() {
		return id_module;
	}

	public void setId_module(Long id_module) {
		this.id_module = id_module;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Filiere getFiliere() {
		return filiere;
	}

	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}

	public Semestre getSemestre() {
		return semestre;
	}

	public void setSemestre(Semestre semestre) {
		this.semestre = semestre;
	}
	 	
}
