package com.CarSelling.project.repository;

import com.CarSelling.project.entity.JanteEntity;
import com.CarSelling.project.entity.JanteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JanteRepository extends JpaRepository<JanteEntity,Integer> {
    @Query("SELECT jante from JanteEntity jante where jante.idjante=:id and jante.etat=:etat")
    List<JanteEntity> findAllByIdAndEtat(@Param("id") Integer id, @Param("etat") Integer etat);

    @Query("SELECT jante from JanteEntity jante where jante.etat=:etat")
    List<JanteEntity> findAllByEtat(@Param("etat") Integer etat);
}
