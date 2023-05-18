package com.gestion.note.Controller;

import com.gestion.note.Service.CompteService;
import com.gestion.note.entities.Compte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gestion.note.Service.AdminService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class LoginController {

    public static final String COMPTE_SESSION_KEY = "compte";
    AdminService adminService;


    CompteService compteService;

    HttpServletRequest httpServletRequest;


    @Autowired
    public LoginController(AdminService adminService, CompteService compteService, HttpServletRequest httpServletRequest) {
        this.adminService = adminService;
        this.compteService = compteService;
        this.httpServletRequest = httpServletRequest;
    }


    @RequestMapping(value = "/Login", method = RequestMethod.POST)
    public ResponseEntity login(@RequestBody Compte compte) {
        //HttpSession session = httpServletRequest.getSession(true);
        //if( session.getAttribute(COMPTE_SESSION_KEY) != null){
          //  return new ResponseEntity<>("Already logged", HttpStatus.BAD_REQUEST);
        //};
        compte = compteService.findCompte(compte);
        if (compte == null) {
            return new ResponseEntity<>("Password ou email erronée", HttpStatus.NOT_FOUND);
        }
        // session.setAttribute(COMPTE_SESSION_KEY, compte);
        return new ResponseEntity<>(compte, HttpStatus.OK);
    }
}
