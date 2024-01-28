package com.CarSelling.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CarSelling.project.entity.ModelEntity;
import com.CarSelling.project.entity.VModelEntity;
import com.CarSelling.project.repository.ModelRepository;
import com.CarSelling.project.repository.VModelRepository;

@Service
public class ModelService {
    @Autowired
    private ModelRepository modelRepository;
    @Autowired
    private VModelRepository vModelRepository;

    public ModelEntity createNewModel(ModelEntity modelEntity) {
        modelEntity.setEtat(1);
        return this.modelRepository.save(modelEntity);
    }

    public List<VModelEntity> getAllModel() {
        return this.vModelRepository.findAll();
    }

    public List<VModelEntity> getAllModelByEtat(Integer etat) {
        return this.vModelRepository.findAllByEtat(etat);
    }

    public List<VModelEntity> getModelById(Integer id) {
        return this.vModelRepository.findAllByIdAndEtat(id, 1);
    }

    @Transactional
    public ModelEntity updateModel(ModelEntity modelEntity) throws Exception {
        try {
            ModelEntity to_update = this.modelRepository.getReferenceById(modelEntity.getIdmodel());
            if (to_update != null) {
                to_update.setEtat(modelEntity.getEtat());
                to_update.setNommodel(modelEntity.getNommodel());
                return this.modelRepository.save(to_update);
            }
        } catch (Exception e) {
            throw e;
        }
        return null;
    }

    public String deleteModel(ModelEntity modelEntity) throws Exception { // changement de l'etaten 0 => delete
        try {
            ModelEntity to_update = this.modelRepository.getReferenceById(modelEntity.getIdmodel());
            if (to_update != null) {
                to_update.setEtat(0);
                to_update.setNommodel(modelEntity.getNommodel());
                this.modelRepository.save(to_update);
            }
        } catch (Exception e) {
            throw e;
        }
        return "ok";
    }

    public String deleteModelById(Integer id) throws Exception { // changement de l'etaten 0 => delete
        try {
            ModelEntity to_update = this.modelRepository.getReferenceById(id);
            if (to_update != null) {
                to_update.setEtat(0);
                this.modelRepository.save(to_update);
            }
        } catch (Exception e) {
            throw e;
        }
        return "ok";
    }

}
