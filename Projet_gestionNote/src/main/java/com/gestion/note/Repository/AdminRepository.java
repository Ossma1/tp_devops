package com.gestion.note.Repository;

import com.gestion.note.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AdminRepository extends 
                          JpaRepository<Admin, Long>{
   
}
