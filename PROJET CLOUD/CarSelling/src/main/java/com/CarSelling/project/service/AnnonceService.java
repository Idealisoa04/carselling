package com.CarSelling.project.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.CarSelling.project.entity.AnnonceEntity;
import com.CarSelling.project.repository.AnnonceRepository;

@Service
public class AnnonceService {
    @Autowired
    private AnnonceRepository annonceRepository;

    private final MongoTemplate mongoTemplate;

    public AnnonceService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<AnnonceEntity> getAnnonceByEtat(Integer etat) {
        return annonceRepository.findByEtat(etat);
    }

    public List<AnnonceEntity> getAnnonceByStatut(Integer statut) {
        return annonceRepository.findByStatut(statut);
    }

    public List<AnnonceEntity> getAllAnnonce() {
        return annonceRepository.findAll();
    }

    public List<AnnonceEntity> getAnnonceById(ObjectId id) {
        return annonceRepository.findBy_id(id);

    }

    public AnnonceEntity createAnnonce(AnnonceEntity annonce) {
        return this.annonceRepository.save(annonce);
    }

    public AnnonceEntity updateAnnonce(AnnonceEntity annonce) throws Exception {
        List<AnnonceEntity> updated_option = this.annonceRepository.findBy_id(annonce.get_id());
        if (updated_option.size() > 0) {
            AnnonceEntity updated = updated_option.get(0);
            // annonce.ge
            updated.setDescription(annonce.getDescription());
            updated.setKilometrage(annonce.getKilometrage());
            updated.setModele(annonce.getModele());
            updated.setPrix(annonce.getPrix());
            updated.setStatut(annonce.getStatut());
            updated.setDate(annonce.getDate());
            System.out.println(annonce.getDate());
            updated.setMoteur(annonce.getMoteur());
            updated.setCouleur(annonce.getCouleur());
            updated.setEtat(annonce.getEtat());
            updated.setJante(annonce.getJante());
            return annonceRepository.save(updated);
        }
        throw new Exception("l annonce n existe pas");
    }

    public String deleteAnnonce(AnnonceEntity annonceEntity) {
        try {
            this.annonceRepository.delete(annonceEntity);
        } catch (

        Exception e) {
            throw e;
        }
        return "ok";
    }

    public String deleteAnnonceById(ObjectId idannonce) {
        try {
            this.annonceRepository.deleteById(idannonce);
        } catch (Exception e) {
            throw e;
        }
        return "ok";
    }

    public String updateEtat(ObjectId id, Integer etat) {
        try {
            mongoTemplate.updateFirst(
                    Query.query(Criteria.where("_id").is(id)),
                    new Update().set("etat", etat),
                    AnnonceEntity.class);
        } catch (Exception e) {
            throw e;
        }
        return "ok";
    }

    public List<AnnonceEntity> getAllByIdAnnonces(Iterable<ObjectId> _ids) {
        return this.annonceRepository.findAllById(_ids);
    }

    public String updateStatut(ObjectId id, Integer statut) throws Exception {
        try {
            mongoTemplate.updateFirst(
                    Query.query(Criteria.where("_id").is(id)),
                    new Update().set("statut", statut),
                    AnnonceEntity.class);
        } catch (Exception e) {
            throw e;
        }
        return "ok";

    }
}
