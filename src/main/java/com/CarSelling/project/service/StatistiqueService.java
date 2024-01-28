package com.CarSelling.project.service;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CarSelling.project.entity.AchatEntity;
import com.CarSelling.project.entity.AnnonceEntity;
import com.CarSelling.project.model.StatistiqueCommission;
import com.CarSelling.project.model.StatistiqueVoitureVendu;
import com.CarSelling.project.tools.Utility;

@Service
public class StatistiqueService {
    @Autowired
    private AnnonceService annonceService;
    @Autowired
    private AchatService achatService;

    @Autowired
    private MarqueService marqueService;

    private Utility utility = new Utility();
    private int[] mois = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };

    public List<AnnonceEntity> getAnnonceParMois(int year, int mois) {
        List<AchatEntity> achatEntities = this.achatService.getAllAchatParMois(year, mois);
        List<ObjectId> idannonces = this.utility.getIdAnnoncesFromAchatList(achatEntities);
        List<AnnonceEntity> annonces = this.annonceService.getAllByIdAnnonces(idannonces);
        return annonces;
    }

    public List<StatistiqueCommission> getCommissionParMois(Integer year) {
        List<AnnonceEntity> annonces = null;
        List<StatistiqueCommission> commissions = new ArrayList();
        StatistiqueCommission commission = null;
        for (int m : mois) {
            commission = new StatistiqueCommission();
            annonces = this.getAnnonceParMois(year, m);
            commission = this.utility.getCommission(annonces, m);
            commissions.add(commission);
        }

        return commissions;
    }

    public List<StatistiqueVoitureVendu> getVoitureVenduParMois(Integer year) {
        List<AnnonceEntity> annonces = null;
        List<StatistiqueVoitureVendu> voitureVendus = new ArrayList();
        StatistiqueVoitureVendu voitureVendu = null;
        for (int m : mois) {
            voitureVendu = new StatistiqueVoitureVendu();
            annonces = this.getAnnonceParMois(year, m);
            voitureVendu.setMois(m);
            voitureVendu.setNombre(Double.valueOf(annonces.size()));
            voitureVendus.add(voitureVendu);
        }

        return voitureVendus;
    }

}
