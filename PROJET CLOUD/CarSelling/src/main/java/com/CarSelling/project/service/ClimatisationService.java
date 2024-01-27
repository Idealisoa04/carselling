package com.CarSelling.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CarSelling.project.entity.ClimatisationEntity;
import com.CarSelling.project.repository.ClimatisationRepository;

@Service
public class ClimatisationService {
    @Autowired
    private ClimatisationRepository carburantRepository;

    public List<ClimatisationEntity> getAllClimatisation() {
        return this.carburantRepository.findAllByEtat(1);
    }

    public List<ClimatisationEntity> getClimatisationById(Integer id) {
        return this.carburantRepository.findAllByIdAndEtat(id, 1);
    }

    public ClimatisationEntity createNewClimatisation(ClimatisationEntity climatisationEntity) throws Exception {
        try {
            climatisationEntity.setEtat(1);
            return this.carburantRepository.save(climatisationEntity);
        } catch (Exception e) {
            throw e;
        }

    }

    public ClimatisationEntity updateClimatisation(ClimatisationEntity climatisationEntity) throws Exception {
        try {
            ClimatisationEntity to_update = this.carburantRepository
                    .getReferenceById(climatisationEntity.getIdclimatisation());
            if (to_update != null) {
                to_update.setEtat(climatisationEntity.getEtat());
                to_update.setNomclimatisation(climatisationEntity.getNomclimatisation());
                return this.carburantRepository.save(to_update);
            }
        } catch (Exception e) {
            throw e;
        }
        return null;
    }

    public String deleteClimatisation(ClimatisationEntity climatisationEntity) throws Exception { // changement de
                                                                                                  // l'etaten 0 =>
                                                                                                  // delete
        try {
            ClimatisationEntity to_update = this.carburantRepository
                    .getReferenceById(climatisationEntity.getIdclimatisation());
            if (to_update != null) {
                to_update.setEtat(0);
                to_update.setNomclimatisation(climatisationEntity.getNomclimatisation());
                this.carburantRepository.save(to_update);
            }
        } catch (Exception e) {
            throw e;
        }
        return "ok";
    }

    public String deleteClimatisationById(Integer id) throws Exception { // changement de l'etaten 0 => delete
        try {
            ClimatisationEntity to_update = this.carburantRepository.getReferenceById(id);
            if (to_update != null) {
                to_update.setEtat(0);
                this.carburantRepository.save(to_update);
            }
        } catch (Exception e) {
            throw e;
        }
        return "ok";
    }

}
