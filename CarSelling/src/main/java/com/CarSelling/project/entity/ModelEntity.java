package com.CarSelling.project.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "model", schema = "public", catalog = "carselling")
public class ModelEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idmodel")
    private Integer idmodel;
    @Basic
    @Column(name = "nommodel")
    private String nommodel;

    @Basic
    @Column(name = "etat")
    private Integer etat;

    @ManyToOne
    @JoinColumn(name = "id_categorie", referencedColumnName = "idcategorie")
    private CategorieEntity categorie;

    @ManyToOne
    @JoinColumn(name = "id_marque", referencedColumnName = "idmarque", nullable = false)
    private MarqueEntity marque;

    @ManyToOne
    @JoinColumn(name = "id_carburant", referencedColumnName = "idcarburant")
    private CarburantEntity carburant;

    @ManyToOne
    @JoinColumn(name = "id_vitesse", referencedColumnName = "idvitesse")
    private VitesseEntity vitesse;

    @ManyToOne
    @JoinColumn(name = "id_climatisation", referencedColumnName = "idclimatisation")
    private ClimatisationEntity climatisation;

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

    public CategorieEntity getCategorie() {
        return categorie;
    }

    public void setCategorie(CategorieEntity categorie) {
        this.categorie = categorie;
    }

    public MarqueEntity getMarque() {
        return marque;
    }

    public void setMarque(MarqueEntity marque) {
        this.marque = marque;
    }

    public CarburantEntity getCarburant() {
        return carburant;
    }

    public void setCarburant(CarburantEntity carburant) {
        this.carburant = carburant;
    }

    public VitesseEntity getVitesse() {
        return vitesse;
    }

    public void setVitesse(VitesseEntity vitesse) {
        this.vitesse = vitesse;
    }

    public ClimatisationEntity getClimatisation() {
        return climatisation;
    }

    public void setClimatisation(ClimatisationEntity climatisation) {
        this.climatisation = climatisation;
    }

    public Integer getEtat() {
        return etat;
    }

    public void setEtat(Integer etat) {
        this.etat = etat;
    }
}
