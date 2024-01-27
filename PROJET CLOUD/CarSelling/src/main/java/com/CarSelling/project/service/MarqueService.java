package com.CarSelling.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CarSelling.project.entity.MarqueEntity;
import com.CarSelling.project.repository.MarqueRepository;

@Service
public class MarqueService {
    @Autowired
    private MarqueRepository marqueRepository;

    public List<MarqueEntity> getAllMarque() {
        return this.marqueRepository.findAllByEtat(1);
    }

    public List<MarqueEntity> getMarqueById(Integer id) {
        return this.marqueRepository.findAllByIdAndEtat(id, 1);
    }

    public MarqueEntity createNewMarque(MarqueEntity marqueEntity) throws Exception {
        try {
            marqueEntity.setEtat(1);
            return this.marqueRepository.save(marqueEntity);
        } catch (Exception e) {
            throw e;
        }

    }

    public MarqueEntity updateMarque(MarqueEntity marqueEntity) throws Exception {
        try {
            MarqueEntity to_update = this.marqueRepository.getReferenceById(marqueEntity.getIdmarque());
            if (to_update != null) {
                to_update.setEtat(marqueEntity.getEtat());
                to_update.setNommarque(marqueEntity.getNommarque());
                return this.marqueRepository.save(to_update);
            }
        } catch (Exception e) {
            throw e;
        }
        return null;
    }

    public String deleteMarque(MarqueEntity marqueEntity) throws Exception { // changement de l'etaten 0 => delete
        try {
            MarqueEntity to_update = this.marqueRepository.getReferenceById(marqueEntity.getIdmarque());
            if (to_update != null) {
                to_update.setEtat(0);
                to_update.setNommarque(marqueEntity.getNommarque());
                this.marqueRepository.save(to_update);
            }
        } catch (Exception e) {
            throw e;
        }
        return "ok";
    }

    public String deleteMarqueById(Integer id) throws Exception { // changement de l'etaten 0 => delete
        try {
            MarqueEntity to_update = this.marqueRepository.getReferenceById(id);
            if (to_update != null) {
                to_update.setEtat(0);
                this.marqueRepository.save(to_update);
            }
        } catch (Exception e) {
            throw e;
        }
        return "ok";
    }
}
