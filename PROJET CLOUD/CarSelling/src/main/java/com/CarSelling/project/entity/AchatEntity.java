package com.CarSelling.project.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "achat", schema = "public", catalog = "carselling")
public class AchatEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idachat")
    private Integer idachat;
    @Basic
    @Column(name = "idannonce")
    private Integer idannonce;

    @Basic
    @Column(name = "etat")
    private Integer etat;
    @ManyToOne
    @JoinColumn(name = "idclient", referencedColumnName = "idutilisateur")
    private UtilisateurEntity utilisateurByIdclient;

    public Integer getIdachat() {
        return idachat;
    }

    public void setIdachat(Integer idachat) {
        this.idachat = idachat;
    }

    public Integer getIdannonce() {
        return idannonce;
    }

    public void setIdannonce(Integer idannonce) {
        this.idannonce = idannonce;
    }

    public Integer getEtat() {
        return etat;
    }

    public void setEtat(Integer etat) {
        this.etat = etat;
    }



    public UtilisateurEntity getUtilisateurByIdclient() {
        return utilisateurByIdclient;
    }

    public void setUtilisateurByIdclient(UtilisateurEntity utilisateurByIdclient) {
        this.utilisateurByIdclient = utilisateurByIdclient;
    }
}
