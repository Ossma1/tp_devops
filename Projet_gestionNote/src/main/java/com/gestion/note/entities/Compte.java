package com.gestion.note.entities;

import javax.persistence.*;

@Entity
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompte;
    @Column
    private String email;
    @Column
    private String password;

    @Enumerated(EnumType.STRING)
    @Column
    private CompteType compteType;


    public Compte(String email, String password) {
        super();
        this.email = email;
        this.password = password;
    }


    public Compte() {
        super();
    }

    public Long getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(Long idCompte) {
        this.idCompte = idCompte;
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

    public CompteType getCompteType() {
        return compteType;
    }

    public void setCompteType(CompteType compteType) {
        this.compteType = compteType;
    }
}
