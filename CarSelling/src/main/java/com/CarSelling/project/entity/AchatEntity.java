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
@Table(name = "achat", schema = "public", catalog = "carselling")
public class AchatEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idachat")
    private Integer idachat;
    @Basic
    @Column(name = "idannonce")
    private String idannonce;

    @ManyToOne
    @JoinColumn(name = "idclient", referencedColumnName = "idutilisateur")
    private UtilisateurEntity utilisateurByIdclient;

    public Integer getIdachat() {
        return idachat;
    }

    public void setIdachat(Integer idachat) {
        this.idachat = idachat;
    }

    public UtilisateurEntity getUtilisateurByIdclient() {
        return utilisateurByIdclient;
    }

    public void setUtilisateurByIdclient(UtilisateurEntity utilisateurByIdclient) {
        this.utilisateurByIdclient = utilisateurByIdclient;
    }

    public String getIdannonce() {
        return idannonce;
    }

    public void setIdannonce(String idannonce) {
        this.idannonce = idannonce;
    }

}
