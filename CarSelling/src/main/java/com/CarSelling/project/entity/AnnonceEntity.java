package com.CarSelling.project.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import jakarta.persistence.Id;

@Document(collection = "annonce")
public class AnnonceEntity {
    @Id
    private ObjectId _id;

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    @Field(name = "id_user")
    private Integer id_user;

    @Field(name = "date")
    // private Timestamp date;
    private LocalDateTime date;

    @Field(name = "prix")
    private Double prix;

    @Field(name = "etat")
    private Integer etat;

    @Field(name = "statut")
    private Integer statut;

    @Field(name = "description")
    private String description;

    @Field(name = "modele")
    private ModelEntity modele;

    @Field(name = "kilometrage")
    private Double kilometrage;

    @Field(name = "jante")
    private JanteEntity jante;

    @Field(name = "moteur")
    private MoteurEntity moteur;

    @Field(name = "couleur")
    private String couleur;

    @Field(name = "photos")
    private List<String> photos;

    @Field(name = "commission")
    private Double commission;

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public Integer getEtat() {
        return etat;
    }

    public void setEtat(Integer etat) {
        this.etat = etat;
    }

    public Integer getStatut() {
        return statut;
    }

    public void setStatut(Integer statut) {
        this.statut = statut;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ModelEntity getModele() {
        return modele;
    }

    public void setModele(ModelEntity modele) {
        this.modele = modele;
    }

    public Double getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(Double kilometrage) {
        this.kilometrage = kilometrage;
    }

    public JanteEntity getJante() {
        return jante;
    }

    public void setJante(JanteEntity jante) {
        this.jante = jante;
    }

    public MoteurEntity getMoteur() {
        return moteur;
    }

    public void setMoteur(MoteurEntity moteur) {
        this.moteur = moteur;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public List<String> getPhotos() {
        return photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }

    public Double getCommission() {
        return commission;
    }

    public void setCommission(Double commission) {
        this.commission = commission;
    }

}
