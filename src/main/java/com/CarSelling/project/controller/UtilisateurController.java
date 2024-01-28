package com.CarSelling.project.controller;

import java.sql.Date;

import javax.crypto.SecretKey;

import com.CarSelling.project.authentification.JwtGenerator;
import com.CarSelling.project.entity.UtilisateurEntity;
import com.CarSelling.project.service.UtilisateurService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;

@RestController
@RequestMapping(path = "/api/usercontroller")
public class UtilisateurController {
    @Autowired
    private UtilisateurService utilisateurService;

    @Autowired
    private  JwtGenerator jwtGenerator;

    @PostMapping("/login")
    public String controlConnexion(@RequestParam(name = "") String email, @RequestParam(name = "") String mdp) throws Exception{
        try {
            String token = this.controlUtilisateur(email, mdp);
            return token;
        } catch (Exception e) {
            throw e;
        }
    }

    @PostMapping("/signin")
    public ResponseEntity<String> insertUtilisateur(@RequestParam(name = "nom") String nom, @RequestParam(name = "prenom") String prenom, @RequestParam(name = "date_naissance") String dtn, @RequestParam(name = "sexe") Integer sexe, @RequestParam(name = "email") String email, @RequestParam(name="mdp") String mdp) throws Exception{
        try {
            this.utilisateurService.insertUser(nom, prenom, dtn, sexe, email, mdp);
            return  ResponseEntity.ok("Tongasoa, Bienvenue ");
        } catch (Exception e) {
            throw e;
        }
    }


    public String controlUtilisateur(String email, String mdp) throws Exception {
        UtilisateurEntity user = null;
        try {
            user = this.utilisateurService.getCurrentUser(email, mdp);
            if(user == null){
                throw new Exception("Il y a erreur, veuillez vérifer votre email ou votre mot de passe");
            } else {
                return this.generateToken(user.getIdutilisateur() , user.getNom());
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @GetMapping("/test")
    public String test() throws Exception{
        try{
            return "helloooooo";
        } catch (Exception e){
            throw e;
        }
    }
    
    @GetMapping("/generate")
    public String generateToken(Integer id, String username) throws Exception{
        String idString = String.valueOf(id);
        try{
            return jwtGenerator.generateJwt(idString, username);
        } catch (Exception e){
            throw e;
        }
    }
    
}
