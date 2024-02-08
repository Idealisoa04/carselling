package com.CarSelling.project.model;

import java.sql.Date;

public class Recherchemodel {
    private Integer idCategorie;
    private Integer idModel;
    private Integer idMarque;
    private Double prix1;
    private Double prix2;
    private Date date1;
    private Date date2;

    public Integer getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(Integer idCategorie) {
        this.idCategorie = idCategorie;
    }

    public Integer getIdModel() {
        return idModel;
    }

    public void setIdModel(Integer idModel) {
        this.idModel = idModel;
    }

    public Integer getIdMarque() {
        return idMarque;
    }

    public void setIdMarque(Integer idMarque) {
        this.idMarque = idMarque;
    }

    public Double getPrix1() {
        return prix1;
    }

    public void setPrix1(Double prix1) {
        this.prix1 = prix1;
    }

    public Double getPrix2() {
        return prix2;
    }

    public void setPrix2(Double prix2) {
        this.prix2 = prix2;
    }

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public Date getDate2() {
        return date2;
    }

    public void setDate2(Date date2) {
        this.date2 = date2;
    }

}
