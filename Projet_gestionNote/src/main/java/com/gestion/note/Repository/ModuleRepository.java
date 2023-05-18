package com.gestion.note.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gestion.note.entities.*;
import com.gestion.note.entities.Module;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Long>{
	@Query("SELECT module FROM Module module where module.filiere.id_filiere = :id_filiere")
    List<Module> findModuleFiliere(@Param("id_filiere") Long id_filiere);
}
