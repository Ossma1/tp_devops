package com.gestion.note.Registration;

import javax.persistence.Column;

public class CompteSave {
	 private Long id_compte;
	 private String email;
     private String password;
     private Long id_prof;
	public Long getId_compte() {
		return id_compte;
	}
	public void setId_compte(Long id_compte) {
		this.id_compte = id_compte;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getId_prof() {
		return id_prof;
	}
	public void setId_prof(Long id_prof) {
		this.id_prof = id_prof;
	}
     
       
     
}
