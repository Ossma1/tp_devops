package com.gestion.note.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Modalite {
	      @Id
	      @GeneratedValue(strategy= GenerationType.IDENTITY)
	      private int id_modalite;
	      @Column
	      private String nom;
	      
		public int getId_modalite() {
			return id_modalite;
		}
		public void setId_modalite(int id_modalite) {
			this.id_modalite = id_modalite;
		}
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		
		
	      
	      
          
          
}
