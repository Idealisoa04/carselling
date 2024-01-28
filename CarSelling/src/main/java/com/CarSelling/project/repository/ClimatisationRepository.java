package com.CarSelling.project.repository;

import com.CarSelling.project.entity.ClimatisationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClimatisationRepository extends JpaRepository<ClimatisationEntity,Integer> {
    @Query("SELECT cli from ClimatisationEntity cli where cli.idclimatisation=:id and cli.etat=:etat")
    List<ClimatisationEntity> findAllByIdAndEtat(@Param("id") Integer id, @Param("etat") Integer etat);

    @Query("SELECT cli from ClimatisationEntity cli where cli.etat=:etat")
    List<ClimatisationEntity> findAllByEtat(@Param("etat") Integer etat);
}
