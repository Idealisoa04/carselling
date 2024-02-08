package com.CarSelling.project.repository;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
// import org.springframework.data.mongodb.repository.WriteResult;
import org.springframework.stereotype.Repository;

import com.CarSelling.project.entity.AnnonceEntity;

@Repository
public interface AnnonceRepository extends MongoRepository<AnnonceEntity, ObjectId> {
    @Query("{ 'etat' : ?0}")
    List<AnnonceEntity> findByEtat(Integer etat);

    @Query("{ 'statut' : ?0 }")
    List<AnnonceEntity> findByStatut(Integer statut);

    List<AnnonceEntity> findBy_id(ObjectId _id);

    @Modifying
    @Query("{'_id': ?0 }")
    long updateEtat(ObjectId id, Integer etat);

    @Modifying
    @Query("{'_id': ?0 }")
    void updateStatut(ObjectId id, Integer statut);


    List<AnnonceEntity> findByModele_Idmodel(Integer idModel);

    List<AnnonceEntity> findByModele_Categorie_Idcategorie(Integer idCategorie);

    List<AnnonceEntity> findByModele_Marque_Idmarque(Integer idMarque);


    @Override
    default List<AnnonceEntity> findAllById(Iterable<ObjectId> ids) {
        List<AnnonceEntity> new_array = new ArrayList();
        for (ObjectId id : ids) {
            new_array.add(this.findBy_id(id).get(0));
        }
        return new_array;
    }

    @Query("{'id_user': ?0 }")
    List<AnnonceEntity> findById_user(Integer id_user);

}