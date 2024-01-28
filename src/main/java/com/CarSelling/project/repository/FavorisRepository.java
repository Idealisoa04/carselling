package com.CarSelling.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.CarSelling.project.entity.FavorisEntity;

public interface FavorisRepository extends JpaRepository<FavorisEntity, Integer> {
    @Query(value = "SELECT * FROM Favoris  where id_utilisateur=:user and etat=:etat", nativeQuery = true)

    public List<FavorisEntity> getFavorisByUser(@Param("user") Integer user, @Param("etat") Integer etat);

    public List<FavorisEntity> findByEtat(Integer etat);
}
