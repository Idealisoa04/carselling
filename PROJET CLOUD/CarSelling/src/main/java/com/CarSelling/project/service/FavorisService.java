package com.CarSelling.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CarSelling.project.entity.FavorisEntity;
import com.CarSelling.project.repository.FavorisRepository;

@Service
public class FavorisService {
    @Autowired
    private FavorisRepository favorisRepository;

    public List<FavorisEntity> getFavorisByUser(Integer iduser, Integer etat) {
        return this.favorisRepository.getFavorisByUser(iduser,
                etat);
    }

    public void addnewFavoris(FavorisEntity favorisEntity) throws Exception {
        try {
            favorisEntity.setEtat(1);
            this.favorisRepository.save(favorisEntity);
        } catch (Exception e) {
            throw e;
        }
    }

    public void removeFromFavoris(Integer idfavoris) throws Exception {
        try {
            FavorisEntity fav = this.favorisRepository.getReferenceById(idfavoris);
            fav.setEtat(0);
            this.favorisRepository.save(fav);
        } catch (Exception e) {
            throw e;
        }
    }
}
