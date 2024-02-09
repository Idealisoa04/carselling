package com.CarSelling.project.entity;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import jakarta.persistence.Id;

@Document(collection = "favorite")
public class FavoriteEntity {
    @Id
    private ObjectId _id;
    @Field(name = "annonce")
    private AnnonceEntity annonceEntity;
    @Field(name = "iduser")
    private Integer iduser;
    @Field(name = "etat")
    private Integer etat;

    public AnnonceEntity getAnnonceEntity() {
        return annonceEntity;
    }

    public void setAnnonceEntity(AnnonceEntity annonceEntity) {
        this.annonceEntity = annonceEntity;
    }

    public Integer getIduser() {
        return iduser;
    }

    public void setIduser(Integer iduser) {
        this.iduser = iduser;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public Integer getEtat() {
        return etat;
    }

    public void setEtat(Integer etat) {
        this.etat = etat;
    }

}
