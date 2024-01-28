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
@Table(name = "favoris", schema = "public", catalog = "carselling")
public class FavorisEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "idannonce")
    private String idannonce;

    @Basic
    @Column(name = "etat") // 0 non et 1 oui
    private Integer etat;
    @ManyToOne
    @JoinColumn(name = "id_utilisateur", referencedColumnName = "idutilisateur")
    private UtilisateurEntity utilisateurByIdUtilisateur;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEtat() {
        return etat;
    }

    public void setEtat(Integer etat) {
        this.etat = etat;
    }

    public UtilisateurEntity getUtilisateurByIdUtilisateur() {
        return utilisateurByIdUtilisateur;
    }

    public void setUtilisateurByIdUtilisateur(UtilisateurEntity utilisateurByIdUtilisateur) {
        this.utilisateurByIdUtilisateur = utilisateurByIdUtilisateur;
    }

    public String getIdannonce() {
        return idannonce;
    }

    public void setIdannonce(String idannonce) {
        this.idannonce = idannonce;
    }
}
