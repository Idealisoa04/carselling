package com.CarSelling.project.entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "climatisation", schema = "public", catalog = "carselling")
public class ClimatisationEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idclimatisation")
    private Integer idclimatisation;
    @Basic
    @Column(name = "nomclimatisation")
    private String nomclimatisation;

    @Basic
    @Column(name = "etat")
    private Integer etat;
    @OneToMany(mappedBy = "climatisation")
    private Collection<ModelEntity> modelsByIdclimatisation;

    public Integer getEtat() {
        return etat;
    }

    public void setEtat(Integer etat) {
        this.etat = etat;
    }

    public Integer getIdclimatisation() {
        return idclimatisation;
    }

    public void setIdclimatisation(Integer idclimatisation) {
        this.idclimatisation = idclimatisation;
    }

    public String getNomclimatisation() {
        return nomclimatisation;
    }

    public void setNomclimatisation(String nomclimatisation) {
        this.nomclimatisation = nomclimatisation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClimatisationEntity that = (ClimatisationEntity) o;
        return Objects.equals(idclimatisation, that.idclimatisation) && Objects.equals(nomclimatisation, that.nomclimatisation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idclimatisation, nomclimatisation);
    }

    public Collection<ModelEntity> getModelsByIdclimatisation() {
        return modelsByIdclimatisation;
    }

    public void setModelsByIdclimatisation(Collection<ModelEntity> modelsByIdclimatisation) {
        this.modelsByIdclimatisation = modelsByIdclimatisation;
    }
}
