package com.CarSelling.project.controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.CarSelling.project.entity.AnnonceEntity;
import com.CarSelling.project.entity.FavorisEntity;
import com.CarSelling.project.entity.UtilisateurEntity;
import com.CarSelling.project.service.AnnonceService;
import com.CarSelling.project.service.FavorisService;
import com.CarSelling.project.tools.Utility;

@RestController
@RequestMapping(path = "/api/favoriscontroller/", method = RequestMethod.GET)
public class FavorisController {
    @Autowired
    private FavorisService favorisService;
    @Autowired
    private AnnonceService annonceService;

    @GetMapping(path = "/favoris")
    public List<AnnonceEntity> getAllfavoris() {
        Integer idUser = 1;
        Integer etat = 1;
        List<FavorisEntity> all_favs = this.favorisService.getFavorisByUser(idUser, etat);
        Utility utility = new Utility();
        List<ObjectId> annonces = utility.getIdAnnoncesFromFAV(all_favs);
        return this.annonceService.getAllByIdAnnonces(annonces);

    }

    @PostMapping(path = "/add")
    public ResponseEntity<String> addNewEntity(@RequestParam(name = "idannonce") String idannonce) {
        FavorisEntity favorisEntity = new FavorisEntity();
        Integer idUser = 1;
        favorisEntity.setIdannonce(idannonce);
        UtilisateurEntity utilisateur = new UtilisateurEntity();
        utilisateur.setIdutilisateur(idUser);
        favorisEntity.setUtilisateurByIdUtilisateur(utilisateur);
        try {
            this.favorisService.addnewFavoris(favorisEntity);
            return ResponseEntity.ok("succes");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<String> RemoveFromfavoris(@RequestParam(name = "idfavoris") Integer idfavoris) {
        try {
            this.favorisService.removeFromFavoris(idfavoris);
            return ResponseEntity.ok("succes");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }

}
