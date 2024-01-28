package com.CarSelling.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CarSelling.project.entity.CategorieEntity;
import com.CarSelling.project.repository.CategorieRepository;

@Service
public class CategorieService {
    @Autowired
    private CategorieRepository categorieRepository;

    public List<CategorieEntity> getAllCategorie() {
        return this.categorieRepository.findAllByEtat(1);
    }

    public List<CategorieEntity> getCategorieById(Integer id) {
        return this.categorieRepository.findAllByIdAndEtat(id, 1);
    }

    @Transactional
    public CategorieEntity createNewCategorie(CategorieEntity categorieEntity) throws Exception {
        try {
            categorieEntity.setEtat(1);
            return this.categorieRepository.save(categorieEntity);
        } catch (Exception e) {
            throw e;
        }

    }

    @Transactional
    public CategorieEntity updateCategorie(CategorieEntity categorieEntity) throws Exception {
        try {
            CategorieEntity to_update = this.categorieRepository.getReferenceById(categorieEntity.getIdcategorie());
            if (to_update != null) {
                to_update.setEtat(categorieEntity.getEtat());
                to_update.setNomcategorie(categorieEntity.getNomcategorie());
                return this.categorieRepository.save(to_update);
            }
        } catch (Exception e) {
            throw e;
        }
        return null;
    }

    public String deleteCategorie(CategorieEntity categorieEntity) throws Exception { // changement de l'etaten 0 =>
                                                                                      // delete
        try {
            CategorieEntity to_update = this.categorieRepository.getReferenceById(categorieEntity.getIdcategorie());
            if (to_update != null) {
                to_update.setEtat(0);
                to_update.setNomcategorie(categorieEntity.getNomcategorie());
                this.categorieRepository.save(to_update);
            }
        } catch (Exception e) {
            throw e;
        }
        return "ok";
    }

    public String deleteCategorieById(Integer id) throws Exception { // changement de l'etaten 0 => delete
        try {
            CategorieEntity to_update = this.categorieRepository.getReferenceById(id);
            if (to_update != null) {
                to_update.setEtat(0);
                this.categorieRepository.save(to_update);
            }
        } catch (Exception e) {
            throw e;
        }
        return "ok";
    }
}
