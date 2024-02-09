package com.CarSelling.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CarSelling.project.entity.FavoriteEntity;
import com.CarSelling.project.repository.FavorisRepository;
import com.CarSelling.project.repository.FavoriteRepository;

@Service
public class FavorisService {
    @Autowired
    private FavorisRepository favorisRepository;
    @Autowired
    private FavoriteRepository favoriteRepository;

    public List<FavoriteEntity> getFavorisByUser(Integer iduser, Integer etat) {
        return this.favoriteRepository.findByIduserAndEtat(iduser,
                etat);// F
    }

    @Transactional
    public void addnewFavoris(FavoriteEntity favorisEntity) throws Exception {
        try {
            favorisEntity.setEtat(1);
            this.favoriteRepository.save(favorisEntity);
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional
    public void removeFromFavoris(FavoriteEntity fav) throws Exception {
        try {

            fav.setEtat(0);
            this.favoriteRepository.save(fav);
        } catch (Exception e) {
            throw e;
        }
    }

}
