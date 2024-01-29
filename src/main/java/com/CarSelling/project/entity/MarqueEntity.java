package com.CarSelling.project.entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "marque", schema = "public", catalog = "carselling")
public class MarqueEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idmarque")
    private Integer idmarque;
    @Basic
    @Column(name = "nommarque")
    private String nommarque;

    @Basic
    @Column(name = "etat")
    private Integer etat;

    public Integer getEtat() {
        return etat;
    }

    public void setEtat(Integer etat) {
        this.etat = etat;
    }

    // @OneToMany(mappedBy = "marque")
    // private Collection<ModelEntity> modelsByIdmarque;

    public Integer getIdmarque() {
        return idmarque;
    }

    public void setIdmarque(Integer idmarque) {
        this.idmarque = idmarque;
    }

    public String getNommarque() {
        return nommarque;
    }

    public void setNommarque(String nommarque) {
        this.nommarque = nommarque;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarqueEntity that = (MarqueEntity) o;
        return Objects.equals(idmarque, that.idmarque) && Objects.equals(nommarque, that.nommarque);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idmarque, nommarque);
    }

    // public Collection<ModelEntity> getModelsByIdmarque() {
    //     return modelsByIdmarque;
    // }

    // public void setModelsByIdmarque(Collection<ModelEntity> modelsByIdmarque) {
    //     this.modelsByIdmarque = modelsByIdmarque;
    // }
}
