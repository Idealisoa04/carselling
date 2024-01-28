package com.CarSelling.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CarSelling.project.entity.AchatEntity;
import com.CarSelling.project.repository.AchatRepository;

@Service
public class AchatService {
    @Autowired
    private AchatRepository achatRepository;

    @Transactional
    public AchatEntity addNewAchat(AchatEntity achatEntity) {
        return this.achatRepository.save(achatEntity);
    }

    public List<AchatEntity> getAllAchat() {
        return this.achatRepository.findAll();
    }

    public List<AchatEntity> getAllAchatParMois(Integer annee, Integer mois) {
        return this.achatRepository.getAchatparMois(annee, mois);
    }

}
