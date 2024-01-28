package com.CarSelling.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CarSelling.project.entity.MoteurEntity;
import com.CarSelling.project.repository.MoteurRepository;

@Service
public class MoteurService {
    @Autowired
    private MoteurRepository moteurRepository;

    public List<MoteurEntity> getAllMoteur() {
        return this.moteurRepository.findAllByEtat(1);
    }

    public List<MoteurEntity> getMoteurById(Integer id) {
        return this.moteurRepository.findAllByIdAndEtat(id, 1);
    }

    @Transactional
    public MoteurEntity createNewMoteur(MoteurEntity moteurEntity) throws Exception {
        try {
            moteurEntity.setEtat(1);
            if (moteurEntity.getCapacite() <= 0) {
                throw new Exception("la capacite du moetur doit etre une valeur positive");
            }
            return this.moteurRepository.save(moteurEntity);
        } catch (Exception e) {
            throw e;
        }

    }

    @Transactional
    public MoteurEntity updateMoteur(MoteurEntity moteurEntity) throws Exception {
        try {
            MoteurEntity to_update = this.moteurRepository.getReferenceById(moteurEntity.getIdmoteur());
            if (to_update != null) {
                to_update.setEtat(moteurEntity.getEtat());
                to_update.setNom(moteurEntity.getNom());
                return this.moteurRepository.save(to_update);
            }
        } catch (Exception e) {
            throw e;
        }
        return null;
    }

    public String deleteMoteur(MoteurEntity moteurEntity) throws Exception { // changement de l'etaten 0 => delete
        try {
            MoteurEntity to_update = this.moteurRepository.getReferenceById(moteurEntity.getIdmoteur());
            if (to_update != null) {
                to_update.setEtat(0);
                to_update.setNom(moteurEntity.getNom());
                this.moteurRepository.save(to_update);
            }
        } catch (Exception e) {
            throw e;
        }
        return "ok";
    }

    public String deleteMoteurById(Integer id) throws Exception { // changement de l'etaten 0 => delete
        try {
            MoteurEntity to_update = this.moteurRepository.getReferenceById(id);
            if (to_update != null) {
                to_update.setEtat(0);
                this.moteurRepository.save(to_update);
                // this.moteurRepository.
            }
        } catch (Exception e) {
            throw e;
        }
        return "ok";
    }

}
