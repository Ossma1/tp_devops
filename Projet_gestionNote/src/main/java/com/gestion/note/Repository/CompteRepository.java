package com.gestion.note.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gestion.note.entities.Compte;

@Repository
public interface CompteRepository extends JpaRepository<Compte, Long>{

    @Query("SELECT compte FROM Compte compte WHERE compte.email = :email AND compte.password = :password")
    Compte findCompteByEmailAndPassword(@Param("email") String email, @Param("password") String password);

}
