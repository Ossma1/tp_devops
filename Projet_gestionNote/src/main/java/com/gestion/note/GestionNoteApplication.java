package com.gestion.note;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "http://localhost:3000/")
@SpringBootApplication
public class GestionNoteApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionNoteApplication.class, args);
	}

}
