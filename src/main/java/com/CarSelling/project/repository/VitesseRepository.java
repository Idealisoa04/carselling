package com.CarSelling.project.repository;

import com.CarSelling.project.entity.VitesseEntity;
import com.CarSelling.project.entity.VitesseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VitesseRepository extends JpaRepository<VitesseEntity,Integer> {
    @Query("SELECT vit from VitesseEntity vit where vit.idvitesse=:id and vit.etat=:etat")
    List<VitesseEntity> findAllByIdAndEtat(@Param("id") Integer id, @Param("etat") Integer etat);
    @Query("SELECT vit from VitesseEntity vit where vit.etat=:etat")
    List<VitesseEntity> findAllByEtat(@Param("etat") Integer etat);
}
