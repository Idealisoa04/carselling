package com.CarSelling.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.CarSelling.project.entity.MoteurEntity;

public interface MoteurRepository extends JpaRepository<MoteurEntity, Integer> {
    @Query("SELECT moteur from MoteurEntity moteur where moteur.idmoteur=:id and moteur.etat=:etat")
    List<MoteurEntity> findAllByIdAndEtat(@Param("id") Integer id, @Param("etat") Integer etat);

    @Query("SELECT moteur from MoteurEntity moteur where moteur.etat=:etat")
    List<MoteurEntity> findAllByEtat(@Param("etat") Integer etat);
}
