package com.CarSelling.project.model;

import com.CarSelling.project.entity.MarqueEntity;

public class StatistiqueMarque {
    private MarqueEntity marqueEntity;
    private Double nombre;

    public MarqueEntity getMarqueEntity() {
        return marqueEntity;
    }

    public void setMarqueEntity(MarqueEntity marqueEntity) {
        this.marqueEntity = marqueEntity;
    }

    public Double getNombre() {
        return nombre;
    }

    public void setNombre(Double nombre) {
        this.nombre = nombre;
    }
}
