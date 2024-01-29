package com.CarSelling.project.entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "vitesse", schema = "public", catalog = "carselling")
public class VitesseEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idvitesse")
    private Integer idvitesse;
    @Basic
    @Column(name = "nomvitesse")
    private String nomvitesse;

    @Basic
    @Column(name = "etat")
    private Integer etat;
    // @OneToMany(mappedBy = "vitesse")
    // private Collection<ModelEntity> modelsByIdvitesse;

    public Integer getIdvitesse() {
        return idvitesse;
    }

    public void setIdvitesse(Integer idvitesse) {
        this.idvitesse = idvitesse;
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
        VitesseEntity that = (VitesseEntity) o;
        return Objects.equals(idvitesse, that.idvitesse) && Objects.equals(nomvitesse, that.nomvitesse);
    }

    public Integer getEtat() {
        return etat;
    }

    public void setEtat(Integer etat) {
        this.etat = etat;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idvitesse, nomvitesse);
    }

    // public Collection<ModelEntity> getModelsByIdvitesse() {
    //     return modelsByIdvitesse;
    // }

    // public void setModelsByIdvitesse(Collection<ModelEntity> modelsByIdvitesse) {
    //     this.modelsByIdvitesse = modelsByIdvitesse;
    // }
}
