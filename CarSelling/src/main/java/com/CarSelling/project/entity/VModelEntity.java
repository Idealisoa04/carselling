package com.CarSelling.project.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "v_model", schema = "public", catalog = "carselling")
public class VModelEntity {
    @Basic
    @Id
    @Column(name = "idmodel")
    private Integer idmodel;
    @Basic
    @Column(name = "nommodel")
    private String nommodel;
    @Basic
    @Column(name = "etat")
    private Integer etat;
    @Basic
    @Column(name = "id_categorie")
    private Integer idCategorie;
    @Basic
    @Column(name = "nomcategorie")
    private String nomcategorie;
    @Basic
    @Column(name = "id_marque")
    private Integer idMarque;
    @Basic
    @Column(name = "nommarque")
    private String nommarque;
    @Basic
    @Column(name = "id_climatisation")
    private Integer idClimatisation;
    @Basic
    @Column(name = "nomclimatisation")
    private String nomclimatisation;
    @Basic
    @Column(name = "id_carburant")
    private Integer idCarburant;
    @Basic
    @Column(name = "nomcarburant")
    private String nomcarburant;
    @Basic
    @Column(name = "id_vitesse")
    private Integer idVitesse;
    @Basic
    @Column(name = "nomvitesse")
    private String nomvitesse;

    public Integer getIdmodel() {
        return idmodel;
    }

    public void setIdmodel(Integer idmodel) {
        this.idmodel = idmodel;
    }

    public String getNommodel() {
        return nommodel;
    }

    public void setNommodel(String nommodel) {
        this.nommodel = nommodel;
    }

    public Integer getEtat() {
        return etat;
    }

    public void setEtat(Integer etat) {
        this.etat = etat;
    }

    public Integer getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(Integer idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getNomcategorie() {
        return nomcategorie;
    }

    public void setNomcategorie(String nomcategorie) {
        this.nomcategorie = nomcategorie;
    }

    public Integer getIdMarque() {
        return idMarque;
    }

    public void setIdMarque(Integer idMarque) {
        this.idMarque = idMarque;
    }

    public String getNommarque() {
        return nommarque;
    }

    public void setNommarque(String nommarque) {
        this.nommarque = nommarque;
    }

    public Integer getIdClimatisation() {
        return idClimatisation;
    }

    public void setIdClimatisation(Integer idClimatisation) {
        this.idClimatisation = idClimatisation;
    }

    public String getNomclimatisation() {
        return nomclimatisation;
    }

    public void setNomclimatisation(String nomclimatisation) {
        this.nomclimatisation = nomclimatisation;
    }

    public Integer getIdCarburant() {
        return idCarburant;
    }

    public void setIdCarburant(Integer idCarburant) {
        this.idCarburant = idCarburant;
    }

    public String getNomcarburant() {
        return nomcarburant;
    }

    public void setNomcarburant(String nomcarburant) {
        this.nomcarburant = nomcarburant;
    }

    public Integer getIdVitesse() {
        return idVitesse;
    }

    public void setIdVitesse(Integer idVitesse) {
        this.idVitesse = idVitesse;
    }

    public String getNomvitesse() {
        return nomvitesse;
    }

    public void setNomvitesse(String nomvitesse) {
        this.nomvitesse = nomvitesse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VModelEntity that = (VModelEntity) o;
        return Objects.equals(idmodel, that.idmodel) && Objects.equals(nommodel, that.nommodel) && Objects.equals(etat, that.etat) && Objects.equals(idCategorie, that.idCategorie) && Objects.equals(nomcategorie, that.nomcategorie) && Objects.equals(idMarque, that.idMarque) && Objects.equals(nommarque, that.nommarque) && Objects.equals(idClimatisation, that.idClimatisation) && Objects.equals(nomclimatisation, that.nomclimatisation) && Objects.equals(idCarburant, that.idCarburant) && Objects.equals(nomcarburant, that.nomcarburant) && Objects.equals(idVitesse, that.idVitesse) && Objects.equals(nomvitesse, that.nomvitesse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idmodel, nommodel, etat, idCategorie, nomcategorie, idMarque, nommarque, idClimatisation, nomclimatisation, idCarburant, nomcarburant, idVitesse, nomvitesse);
    }
}
