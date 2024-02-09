package com.CarSelling.project.repository;

import java.sql.Date;

import com.CarSelling.project.entity.UtilisateurEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<UtilisateurEntity,Integer> {
    
    @Query(value = "SELECT * FROM utilisateur where email = :email and mdp = :mdp", nativeQuery = true)
    public UtilisateurEntity getCurrentUser(@Param("email") String email, @Param("mdp") String mdp );

    @Query(value = "SELECT * FROM utilisateur where idutilisateur = :idutilisateur", nativeQuery = true)
    public UtilisateurEntity findUserById(@Param("idutilisateur") Integer id);

    @Query(value = "INSERT INTO utilisateur (nom,prenom,date_naissance,sexe,email,mdp) values (:nom,:prenom,:date_naissance,:sexe,:email,:mdp)", nativeQuery = true)
    public UtilisateurEntity insertUtilisateur( @Param("nom") String nom, @Param("prenom") String prenom, @Param("date_naissance") Date dtn, @Param("sexe") Integer sexe, @Param("email") String email, @Param("mdp") String mdp);
}
