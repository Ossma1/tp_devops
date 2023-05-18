package com.gestion.note.entities;


import javax.persistence.*;

@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id_admin;
    @Column
    private String nom;
    @Column
    private String prenom;
    @OneToOne
	private Compte compte;
    
	public Admin(Long id_admin, String nom, String prenom) {
		super();
		this.id_admin = id_admin;
		this.nom = nom;
		this.prenom = prenom;
	}
	
	

	public Admin(Long id_admin, String nom, String prenom, Compte compte) {
		super();
		this.id_admin = id_admin;
		this.nom = nom;
		this.prenom = prenom;
		this.compte = compte;
	}



	public Admin() {
		super();
	}
	public Long getId_admin() {
		return id_admin;
	}
	public void setId_admin(Long id_admin) {
		this.id_admin = id_admin;
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

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	@Override
	public String toString() {
		return "Admin [id_admin=" + id_admin + ", nom=" + nom + ", prenom=" + prenom + ", compte=" + compte + "]";
	}
    
	
	

    
}
