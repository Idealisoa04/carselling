package com.CarSelling.project.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CarSelling.project.entity.AnnonceEntity;
import com.CarSelling.project.model.Recherchemodel;

@Service
public class RerchercheService {
    @Autowired
    private AnnonceService annonceService;

    public List<AnnonceEntity> getAllBetweenDate(Date date1, Date date2, List<AnnonceEntity> annonceEntitys) {
        List<AnnonceEntity> all = new ArrayList();
        Date annonce_date = null;
        for (AnnonceEntity a : annonceEntitys) {
            annonce_date = Date.valueOf(a.getDate().toLocalDate());
            if (date1.before(annonce_date) == true && date2.after(annonce_date) == true) {
                all.add(a);
            }
        }
        return all;
    }

    public List<AnnonceEntity> getAllBetweenPrice(Double prix1, Double prix2, List<AnnonceEntity> annonceEntitys) {
        List<AnnonceEntity> all = new ArrayList();
        for (AnnonceEntity a : annonceEntitys) {
            if (a.getPrix().doubleValue() >= prix1.doubleValue() && a.getPrix().doubleValue() <= prix2.doubleValue()) {
                all.add(a);
            }
        }
        return all;
    }

    public List<AnnonceEntity> getAllAnnonce(Recherchemodel recherche) {
        List<AnnonceEntity> annonceEntities = this.getAnnonceUpToCondition(recherche);
        System.out.println(annonceEntities.size() + " " + recherche.getDate1() + " " + recherche.getDate2());

        if (recherche.getDate1() != null && recherche.getDate2() != null) {
            annonceEntities = this.getAllBetweenDate(recherche.getDate1(),
                    recherche.getDate2(), annonceEntities);
            display(annonceEntities);
        }
        if (recherche.getPrix1() != null && recherche.getPrix2() != null) {
            System.out.println(recherche.getPrix1() + "hey " + recherche.getPrix2());

            annonceEntities = this.getAllBetweenPrice(recherche.getPrix1(),
                    recherche.getPrix2(), annonceEntities);

        }
        return annonceEntities;
    }

    public void display(List<AnnonceEntity> annonceEntities) {
        for (AnnonceEntity annonceEntity : annonceEntities) {
            System.out.println(annonceEntity.getPrix() + annonceEntity.getDescription());
        }
    }

    public List<AnnonceEntity> getAnnonceUpToCondition(Recherchemodel recherchemodel) {
        List<AnnonceEntity> all = new ArrayList();

        if (recherchemodel != null) {

            if (recherchemodel.getIdModel() != null) {

                all = this.annonceService.getAnnonceByModel(recherchemodel.getIdModel());

                if (recherchemodel.getIdCategorie() != null) {
                    all = this.getSimilaritiesCategorie(all, recherchemodel.getIdCategorie());
                }
                if (recherchemodel.getIdMarque() != null) {
                    all = this.getSimilaritiesMarque(all, recherchemodel.getIdMarque());
                }

            } else if (recherchemodel.getIdCategorie() != null || recherchemodel.getIdMarque() != null) {
                if (recherchemodel.getIdCategorie() != null) {
                    all = this.annonceService.getAnnonceByCategorie(recherchemodel.getIdCategorie());
                    if (recherchemodel.getIdMarque() != null) {
                        all = this.getSimilaritiesMarque(all, recherchemodel.getIdMarque());
                    }
                } else if (recherchemodel.getIdMarque() != null) {
                    all = this.annonceService.getAnnonceByMarque(recherchemodel.getIdMarque());

                }

            } else {
                all = annonceService.getAllAnnonce();
            }

        }
        System.out.println(all.size() + " taille de l'annonce");
        return all;
    }

    public List<AnnonceEntity> getSimilaritiesCategorie(List<AnnonceEntity> annonces, Integer idCategorie) {
        List<AnnonceEntity> all = new ArrayList();
        for (AnnonceEntity annonce : annonces) {
            if (annonce.getModele().getCategorie().getIdcategorie() == idCategorie) {
                all.add(annonce);
            }
        }
        return all;
    }

    public List<AnnonceEntity> getSimilaritiesMarque(List<AnnonceEntity> annonces, Integer idMarque) {
        List<AnnonceEntity> all = new ArrayList();
        for (AnnonceEntity annonce : annonces) {
            if (annonce.getModele().getMarque().getIdmarque() == idMarque) {
                all.add(annonce);
            }
        }
        return all;
    }

}
