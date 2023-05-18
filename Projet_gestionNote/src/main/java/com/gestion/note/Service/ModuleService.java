package com.gestion.note.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gestion.note.Repository.ModuleRepository;
import com.gestion.note.entities.Element;
import com.gestion.note.entities.Module;

@Service
public class ModuleService {
    
	@Autowired
	ModuleRepository moduleRepository;

	public ModuleService(ModuleRepository moduleRepository) {
		super();
		this.moduleRepository = moduleRepository;
	}
	
	public List<Module> findModuleFiliere(Long id_filiere){
		List<Module> modules=moduleRepository.findModuleFiliere(id_filiere);
		return modules;
         }
}
