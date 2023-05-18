package com.gestion.note.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gestion.note.entities.Element;
import com.gestion.note.entities.note;

@Repository
public interface noteRepository extends JpaRepository<note, Long>{
	@Query("SELECT note FROM note note where note.element.nom = :nom")
    List<note> noteElement(@Param("nom") String nom);
}
