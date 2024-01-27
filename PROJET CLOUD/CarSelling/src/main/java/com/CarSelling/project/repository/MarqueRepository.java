package com.CarSelling.project.repository;

import com.CarSelling.project.entity.MarqueEntity;
import com.CarSelling.project.entity.MarqueEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarqueRepository extends JpaRepository<MarqueEntity,Integer> {
    @Query("SELECT marque from MarqueEntity marque where marque.idmarque=:id and marque.etat=:etat")
    List<MarqueEntity> findAllByIdAndEtat(@Param("id") Integer id, @Param("etat") Integer etat);

    @Query("SELECT marque from MarqueEntity marque where marque.etat=:etat")
    List<MarqueEntity> findAllByEtat(@Param("etat") Integer etat);
}

