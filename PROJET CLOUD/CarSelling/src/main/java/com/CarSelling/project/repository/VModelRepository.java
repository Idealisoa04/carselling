package com.CarSelling.project.repository;

import com.CarSelling.project.entity.VModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
@Repository
public interface VModelRepository extends JpaRepository<VModelEntity,Integer> {

    @Query("SELECT model from VModelEntity model where model.idmodel=:id and model.etat=:etat")
    List<VModelEntity> findAllByIdAndEtat(@Param("id") Integer id, @Param("etat") Integer etat);

    @Query("SELECT model from VModelEntity model where model.etat=:etat")
    List<VModelEntity> findAllByEtat(@Param("etat") Integer etat);
}
