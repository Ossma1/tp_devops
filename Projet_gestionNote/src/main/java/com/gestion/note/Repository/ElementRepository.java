package com.gestion.note.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gestion.note.entities.Compte;
import com.gestion.note.entities.Element;


@Repository
public interface ElementRepository extends JpaRepository<Element, Long>{
	@Query("SELECT element FROM Element element where element.professeur.id_prof = :id_prof")
    List<Element> findProfElement(@Param("id_prof") Long id_prof);
	
	@Query("SELECT element FROM Element element where element.module.id_module = :id_module")
	List<Element> findModuleElement(@Param("id_module") Long id_module);
}
