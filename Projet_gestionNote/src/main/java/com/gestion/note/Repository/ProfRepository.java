package com.gestion.note.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gestion.note.entities.Compte;
import com.gestion.note.entities.Professeur;

public interface ProfRepository extends JpaRepository<Professeur,Long>{
	@Query("SELECT professeur FROM Professeur professeur WHERE professeur.compte.idCompte = :idCompte ")
    Professeur findProfesseurbycompte(@Param("idCompte") Long idCompte);


}
