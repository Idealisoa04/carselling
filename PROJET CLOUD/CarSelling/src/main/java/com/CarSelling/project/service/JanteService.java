package com.CarSelling.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CarSelling.project.entity.JanteEntity;
import com.CarSelling.project.repository.JanteRepository;

@Service
public class JanteService {
    @Autowired
    private JanteRepository janteRepository;

    public List<JanteEntity> getAllJante() {
        return this.janteRepository.findAllByEtat(1);
    }

    public List<JanteEntity> getJanteById(Integer id) {
        return this.janteRepository.findAllByIdAndEtat(id, 1);
    }

    public JanteEntity createNewJante(JanteEntity janteEntity) {
        try {
            janteEntity.setEtat(1);
            return this.janteRepository.save(janteEntity);
        } catch (Exception e) {
            throw e;
        }

    }

    public JanteEntity updateJante(JanteEntity janteEntity) throws Exception {
        try {
            JanteEntity to_update = this.janteRepository.getReferenceById(janteEntity.getIdjante());
            if (to_update != null) {
                to_update.setEtat(janteEntity.getEtat());
                to_update.setNomjante(janteEntity.getNomjante());
                return this.janteRepository.save(to_update);
            }
        } catch (Exception e) {
            throw e;
        }
        return null;
    }

    public String deleteJante(JanteEntity janteEntity) throws Exception { // changement de l'etaten 0 => delete
        try {
            JanteEntity to_update = this.janteRepository.getReferenceById(janteEntity.getIdjante());
            if (to_update != null) {
                to_update.setEtat(0);
                to_update.setNomjante(janteEntity.getNomjante());
                this.janteRepository.save(to_update);
            }
        } catch (Exception e) {
            throw e;
        }
        return "ok";
    }

    public String deleteJanteById(Integer id) throws Exception { // changement de l'etaten 0 => delete
        try {
            JanteEntity to_update = this.janteRepository.getReferenceById(id);
            if (to_update != null) {
                to_update.setEtat(0);
                this.janteRepository.save(to_update);
            }
        } catch (Exception e) {
            throw e;
        }
        return "ok";
    }

}
