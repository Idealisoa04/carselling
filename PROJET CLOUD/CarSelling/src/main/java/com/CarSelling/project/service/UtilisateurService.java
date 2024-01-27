package com.CarSelling.project.service;


import java.sql.Date;

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

    public void insertUser(String nom, String prenom, Date dtn, Integer sexe, String email, String mdp ) throws Exception{
        try {
            this.utilisateurRepository.insertUtilisateur(nom, prenom, dtn, sexe, email, mdp);
        } catch (Exception e) {
            throw e;
        }
    }

}
