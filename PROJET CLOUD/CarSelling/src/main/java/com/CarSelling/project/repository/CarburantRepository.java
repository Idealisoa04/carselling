package com.CarSelling.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.CarSelling.project.entity.CarburantEntity;

import java.util.List;

@Repository
public interface CarburantRepository extends JpaRepository<CarburantEntity, Integer> {
    @Query("SELECT car from CarburantEntity car where car.idcarburant=:id and car.etat=:etat")
    List<CarburantEntity> findAllByIdAndEtat(@Param("id") Integer id,@Param("etat") Integer etat);

    @Query("SELECT car from CarburantEntity car where car.etat=:etat")
    List<CarburantEntity> findAllByEtat(@Param("etat") Integer etat);
}
