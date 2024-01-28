package com.CarSelling.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.CarSelling.project.entity.ModelEntity;

@Repository
public interface ModelRepository extends JpaRepository<ModelEntity, Integer> {
//    @Query("SELECT model from ModelEntity model where model.idmodel=:id and model.etat=:etat")
//    List<ModelEntity> findAllByIdAndEtat(@Param("id") Integer id, @Param("etat") Integer etat);
//
//    @Query("SELECT model from ModelEntity model where model.etat=:etat")
//    List<ModelEntity> findAllByEtat(@Param("etat") Integer etat);


}
