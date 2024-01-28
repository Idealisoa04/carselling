package com.CarSelling.project.entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "carburant", schema = "public", catalog = "carselling")
public class CarburantEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idcarburant")
    private Integer idcarburant;
    @Basic
    @Column(name = "nomcarburant")
    private String nomcarburant;

    public Integer getEtat() {
        return etat;
    }

    public void setEtat(Integer etat) {
        this.etat = etat;
    }

    @Basic
    @Column(name = "etat")
    private Integer etat;
    @OneToMany(mappedBy = "carburant")
    private Collection<ModelEntity> modelsByIdcarburant;

    public Integer getIdcarburant() {
        return idcarburant;
    }

    public void setIdcarburant(Integer idcarburant) {
        this.idcarburant = idcarburant;
    }

    public String getNomcarburant() {
        return nomcarburant;
    }

    public void setNomcarburant(String nomcarburant) {
        this.nomcarburant = nomcarburant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarburantEntity that = (CarburantEntity) o;
        return Objects.equals(idcarburant, that.idcarburant) && Objects.equals(nomcarburant, that.nomcarburant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idcarburant, nomcarburant);
    }

    public Collection<ModelEntity> getModelsByIdcarburant() {
        return modelsByIdcarburant;
    }

    public void setModelsByIdcarburant(Collection<ModelEntity> modelsByIdcarburant) {
        this.modelsByIdcarburant = modelsByIdcarburant;
    }
}
