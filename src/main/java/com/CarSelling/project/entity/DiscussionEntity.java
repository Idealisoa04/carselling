package com.CarSelling.project.entity;

import java.util.Objects;

import com.CarSelling.project.service.UtilisateurService;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "discussion", schema = "public", catalog = "carselling")
public class DiscussionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "iddiscussion")
    private Integer iddiscussion;

    @Column(name = "iduser1")
    private Integer iduser1;

    @Column(name = "iduser2")
    private Integer iduser2;

    // @Autowired
    // private UtilisateurService utilisateurService;

    // @Autowired
    // private UtilisateurEntity utilisateurEntity;



    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiscussionEntity that = (DiscussionEntity) o;
        return Objects.equals(iddiscussion, that.iddiscussion) && Objects.equals(iduser1, that.iduser1) && Objects.equals(iduser2, that.iduser2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iddiscussion,iduser1,iduser2);
    }

    // public void getInfoRecipient(Integer iduser) {
    //     UtilisateurEntity user = this.utilisateurService.findUserById(iduser);
    //     user.setMdp(null);
    //     this.setUtilisateurEntity(user);
    // }

    public Integer getIddiscussion() {
        return iddiscussion;
    }

    public void setIddiscussion(Integer iddiscussion) {
        this.iddiscussion = iddiscussion;
    }

    public Integer getIduser1() {
        return iduser1;
    }

    public void setIduser1(Integer iduser1) {
        this.iduser1 = iduser1;
    }

    public Integer getIduser2() {
        return iduser2;
    }

    public void setIduser2(Integer iduser2) {
        this.iduser2 = iduser2;
    }

    // public UtilisateurEntity getUtilisateurEntity() {
    //     return utilisateurEntity;
    // }

    // public void setUtilisateurEntity(UtilisateurEntity utilisateurEntity) {
    //     this.utilisateurEntity = utilisateurEntity;
    // }
}
