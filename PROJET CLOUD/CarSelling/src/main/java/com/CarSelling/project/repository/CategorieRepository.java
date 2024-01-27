package com.CarSelling.project.repository;

import com.CarSelling.project.entity.CategorieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategorieRepository extends JpaRepository<CategorieEntity,Integer> {
    @Query("SELECT cat from CategorieEntity cat where cat.idcategorie=:id and cat.etat=:etat")
    List<CategorieEntity> findAllByIdAndEtat(@Param("id") Integer id, @Param("etat") Integer etat);

    @Query("SELECT cat from CategorieEntity cat where cat.etat=:etat")
    List<CategorieEntity> findAllByEtat(@Param("etat") Integer etat);
}
