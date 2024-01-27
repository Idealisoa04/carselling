package com.CarSelling.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CarSelling.project.entity.VitesseEntity;
import com.CarSelling.project.repository.VitesseRepository;

@Service
public class VitesseService {
    @Autowired
    private VitesseRepository vitesseRepository;

    public List<VitesseEntity> getAllVitesse() {
        return this.vitesseRepository.findAllByEtat(1);
    }

    public List<VitesseEntity> getVitesseById(Integer id) {
        return this.vitesseRepository.findAllByIdAndEtat(id, 1);
    }

    public VitesseEntity createNewVitesse(VitesseEntity vitesseEntity) throws Exception {
        try {
            return this.vitesseRepository.save(vitesseEntity);
        } catch (Exception e) {
            throw e;
        }

    }

    public VitesseEntity updateVitesse(VitesseEntity vitesseEntity) throws Exception {
        try {
            VitesseEntity to_update = this.vitesseRepository.getReferenceById(vitesseEntity.getIdvitesse());
            if (to_update != null) {
                to_update.setEtat(vitesseEntity.getEtat());
                to_update.setNomvitesse(vitesseEntity.getNomvitesse());
                return this.vitesseRepository.save(to_update);
            }
        } catch (Exception e) {
            throw e;
        }
        return null;
    }

    public String deleteVitesse(VitesseEntity vitesseEntity) throws Exception { // changement de l'etaten 0 => delete
        try {
            VitesseEntity to_update = this.vitesseRepository.getReferenceById(vitesseEntity.getIdvitesse());
            if (to_update != null) {
                to_update.setEtat(0);
                to_update.setNomvitesse(vitesseEntity.getNomvitesse());
                this.vitesseRepository.save(to_update);
            }
        } catch (Exception e) {
            throw e;
        }
        return "ok";
    }

    public String deleteVitesseById(Integer id) throws Exception { // changement de l'etaten 0 => delete
        try {
            VitesseEntity to_update = this.vitesseRepository.getReferenceById(id);
            if (to_update != null) {
                to_update.setEtat(0);
                this.vitesseRepository.save(to_update);
            }
        } catch (Exception e) {
            throw e;
        }
        return "ok";
    }
}
