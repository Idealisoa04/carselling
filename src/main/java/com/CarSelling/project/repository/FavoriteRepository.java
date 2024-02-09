package com.CarSelling.project.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.CarSelling.project.entity.FavoriteEntity;

@Repository
public interface FavoriteRepository extends MongoRepository<FavoriteEntity, ObjectId> {

    List<FavoriteEntity> findByIduserAndEtat(Integer iduser, Integer etat);
}
