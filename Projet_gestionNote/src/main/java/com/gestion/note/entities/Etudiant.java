package com.gestion.note.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.*;




@Entity
public class Etudiant {
   @Id
   @GeneratedValue(strategy= GenerationType.IDENTITY)
   private long id_etudiant;
   private String nom;
   private String prenom;
public long getId_etudiant() {
	return id_etudiant;
}
public void setId_etudiant(long id_etudiant) {
	this.id_etudiant = id_etudiant;
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
    
   
   
   
}
