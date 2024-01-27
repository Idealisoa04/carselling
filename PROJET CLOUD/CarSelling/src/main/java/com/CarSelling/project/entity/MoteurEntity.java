package com.CarSelling.project.entity;

import java.util.Objects;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "moteur", schema = "public", catalog = "carselling")
public class MoteurEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idmoteur")
    private Integer idmoteur;
    @Basic
    @Column(name = "capacite")
    private Double capacite;
    @Basic
    @Column(name = "nom")
    private String nom;

    @Basic
    @Column(name = "etat")
    private Integer etat;

    public Integer getIdmoteur() {
        return idmoteur;
    }

    public void setIdmoteur(Integer idmoteur) {
        this.idmoteur = idmoteur;
    }

    public Double getCapacite() {
        return capacite;
    }

    public void setCapacite(Double capacite) {
        this.capacite = capacite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        MoteurEntity that = (MoteurEntity) o;
        return Objects.equals(idmoteur, that.idmoteur) && Objects.equals(capacite, that.capacite)
                && Objects.equals(nom, that.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idmoteur, capacite, nom);
    }

    public Integer getEtat() {
        return etat;
    }

    public void setEtat(Integer etat) {
        this.etat = etat;
    }
}
