package com.CarSelling.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.CarSelling.project.entity.AchatEntity;

@Repository
public interface AchatRepository extends JpaRepository<AchatEntity, Integer> {
    @Query(value = "SELECT * FROM achat WHERE EXTRACT(YEAR FROM date) = :year AND EXTRACT(MONTH FROM date) = :month", nativeQuery = true)
    public List<AchatEntity> getAchatparMois(@Param("year") Integer year, @Param("month") Integer mois);
}
