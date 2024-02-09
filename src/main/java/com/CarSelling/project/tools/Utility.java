package com.CarSelling.project.tools;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import com.CarSelling.project.entity.AchatEntity;
import com.CarSelling.project.entity.AnnonceEntity;
import com.CarSelling.project.entity.FavorisEntity;
import com.CarSelling.project.entity.FavoriteEntity;
import com.CarSelling.project.model.StatistiqueCommission;

public class Utility {
    // @Autowired
    // private Converter<String, ObjectId> stringToObjectIdConverter;
    // private int[] mois = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };

    public List<ObjectId> getIdAnnoncesFromFAV(List<FavorisEntity> favs) {
        List<ObjectId> array_Ids = new ArrayList<>();

        for (FavorisEntity f : favs) {
            array_Ids.add(new ObjectId(f.getIdannonce()));

        }
        return array_Ids;
    }

    public List<ObjectId> getIdAnnoncesFromAchatList(List<AchatEntity> favs) {
        List<ObjectId> array_Ids = new ArrayList<>();

        for (AchatEntity f : favs) {
            array_Ids.add(new ObjectId(f.getIdannonce()));

        }
        return array_Ids;
    }

    public StatistiqueCommission getCommission(List<AnnonceEntity> annonces, int mois) {
        StatistiqueCommission statistiqueCommission = new StatistiqueCommission();
        statistiqueCommission.setMois(mois);
        Double commission = 0.0;
        for (AnnonceEntity annonceEntity : annonces) {
            System.out.println("");
            commission = commission + (annonceEntity.getPrix() * annonceEntity.getCommission()) / 100;
        }
        statistiqueCommission.setValeur(commission);
        return statistiqueCommission;
    }

    public List<AnnonceEntity> convert(List<FavoriteEntity> array) {
        List<AnnonceEntity> all = new ArrayList();
        for (FavoriteEntity fav : array) {
            all.add(fav.getAnnonceEntity());
        }
        return all;

    }
}
