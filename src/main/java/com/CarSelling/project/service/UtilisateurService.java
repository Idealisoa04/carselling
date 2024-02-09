package com.CarSelling.project.service;


import java.sql.Date;
import java.text.SimpleDateFormat;

import com.CarSelling.project.entity.UtilisateurEntity;
import com.CarSelling.project.repository.UtilisateurRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurService {
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public UtilisateurEntity getCurrentUser(String email, String mdp){
        return this.utilisateurRepository.getCurrentUser(email, mdp);
    }

    public UtilisateurEntity findUserById(Integer id){
        return this.utilisateurRepository.findUserById(id);
    }


    // public UtilisateurEntity insertUser(String nom, String prenom, String dtn, Integer sexe, String email, String mdp ) throws Exception{
    //     try {
    //         java.sql.Date sqlDate = java.sql.Date.valueOf(dtn);
    //         System.out.println(sqlDate);
    //         return this.utilisateurRepository.insertUtilisateur(nom, prenom, sqlDate, sexe, email, mdp);
    //     } catch (Exception e) {
    //         throw e;
    //     }
    // }

    public UtilisateurEntity insertUser(String nom, String prenom, String dtn, Integer sexe, String email, String mdp ) throws Exception{
        try {
            java.sql.Date sqlDate = java.sql.Date.valueOf(dtn);
            System.out.println(sqlDate);
            UtilisateurEntity user = new UtilisateurEntity();
            user.setNom(nom);
            user.setPrenom(prenom);
            user.setDateNaissance(sqlDate);
            user.setSexe(sexe);
            user.setEmail(email);
            user.setMdp(mdp);
            user.setIsadmin(0);
            return this.utilisateurRepository.save(user);
        } catch (Exception e) {
            throw e;
        }
    }

}
