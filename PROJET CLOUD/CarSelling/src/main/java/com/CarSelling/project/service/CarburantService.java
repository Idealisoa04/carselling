package com.CarSelling.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CarSelling.project.entity.CarburantEntity;
import com.CarSelling.project.repository.CarburantRepository;

@Service
public class CarburantService {
    @Autowired
    private CarburantRepository carburantRepository;

    public List<CarburantEntity> getAllCarburant() {
        return this.carburantRepository.findAllByEtat(1);
    }

    public List<CarburantEntity> getCarburantById(Integer id) {
        return this.carburantRepository.findAllByIdAndEtat(id, 1);
    }

    public CarburantEntity createNewCarburant(CarburantEntity carburantEntity) throws Exception {
        try {
            carburantEntity.setEtat(1);
            return this.carburantRepository.save(carburantEntity);
        } catch (Exception e) {
            throw e;
        }

    }

    public CarburantEntity updateCarburant(CarburantEntity carburantEntity) throws Exception {
        try {
            CarburantEntity to_update = this.carburantRepository.getReferenceById(carburantEntity.getIdcarburant());
            if (to_update != null) {
                to_update.setEtat(carburantEntity.getEtat());
                to_update.setNomcarburant(carburantEntity.getNomcarburant());
                return this.carburantRepository.save(to_update);
            }
        } catch (Exception e) {
            throw e;
        }
        return null;
    }

    public String deleteCarburant(CarburantEntity carburantEntity) throws Exception { // changement de l'etaten 0 =>
                                                                                      // delete
        try {
            CarburantEntity to_update = this.carburantRepository.getReferenceById(carburantEntity.getIdcarburant());
            if (to_update != null) {
                to_update.setEtat(0);
                to_update.setNomcarburant(carburantEntity.getNomcarburant());
                this.carburantRepository.save(to_update);
            }
        } catch (Exception e) {
            throw e;
        }
        return "ok";
    }

    public String deleteCarburantById(Integer id) throws Exception { // changement de l'etaten 0 => delete
        try {
            CarburantEntity to_update = this.carburantRepository.getReferenceById(id);
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
