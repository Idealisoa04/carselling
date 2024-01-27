package com.CarSelling.project.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "utilisateur", schema = "public", catalog = "carselling")
public class UtilisateurEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idutilisateur")
    private Integer idutilisateur;
    @Basic
    @Column(name = "nom")
    private String nom;
    @Basic
    @Column(name = "prenom")
    private String prenom;
    @Basic
    @Column(name = "date_naissance")
    private Date dateNaissance;
    @Basic
    @Column(name = "sexe")
    private Integer sexe;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "mdp")
    private String mdp;
    @Basic
    @Column(name = "isadmin")
    private Integer isadmin;
    @OneToMany(mappedBy = "utilisateurByIdclient")
    private Collection<AchatEntity> achatsByIdutilisateur;
    @OneToMany(mappedBy = "utilisateurByIdUtilisateur")
    private Collection<FavorisEntity> favorisesByIdutilisateur;

    public Integer getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(Integer idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Integer getSexe() {
        return sexe;
    }

    public void setSexe(Integer sexe) {
        this.sexe = sexe;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public Integer getIsadmin() {
        return isadmin;
    }

    public void setIsadmin(Integer isadmin) {
        this.isadmin = isadmin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UtilisateurEntity that = (UtilisateurEntity) o;
        return Objects.equals(idutilisateur, that.idutilisateur) && Objects.equals(nom, that.nom) && Objects.equals(prenom, that.prenom) && Objects.equals(dateNaissance, that.dateNaissance) && Objects.equals(sexe, that.sexe) && Objects.equals(email, that.email) && Objects.equals(mdp, that.mdp) && Objects.equals(isadmin, that.isadmin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idutilisateur, nom, prenom, dateNaissance, sexe, email, mdp, isadmin);
    }

    public Collection<AchatEntity> getAchatsByIdutilisateur() {
        return achatsByIdutilisateur;
    }

    public void setAchatsByIdutilisateur(Collection<AchatEntity> achatsByIdutilisateur) {
        this.achatsByIdutilisateur = achatsByIdutilisateur;
    }

    public Collection<FavorisEntity> getFavorisesByIdutilisateur() {
        return favorisesByIdutilisateur;
    }

    public void setFavorisesByIdutilisateur(Collection<FavorisEntity> favorisesByIdutilisateur) {
        this.favorisesByIdutilisateur = favorisesByIdutilisateur;
    }
}
