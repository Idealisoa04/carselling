package com.CarSelling.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.CarSelling.project.Config.JwtService;
import com.CarSelling.project.entity.AnnonceEntity;
import com.CarSelling.project.entity.FavoriteEntity;
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
    @Autowired
    private JwtService jwtService;

    @GetMapping(path = "/favoris")
    public List<AnnonceEntity> getAllfavoris(@RequestHeader(name = "Authorization") String authHeader) throws Exception{
        try{
            String jwt = authHeader.substring(7);
            String idU = jwtService.extractUsername(jwt);
        Integer idUser = Integer.valueOf(idU);
        Integer etat = 1;
        List<FavoriteEntity> all_favs = this.favorisService.getFavorisByUser(idUser, etat);
        Utility util = new Utility();
        List<AnnonceEntity> all = util.convert(all_favs);
        return all;
        } catch (Exception e){
            throw e;
        }

    }

    @PostMapping(path = "/add")
    public ResponseEntity<String> addNewFavoris(@RequestBody AnnonceEntity annonce,@RequestHeader(name = "Authorization") String authHeader) throws Exception{
        try{
            String jwt = authHeader.substring(7);
            String idUser = jwtService.extractUsername(jwt);
        FavoriteEntity favorisEntity = new FavoriteEntity();
        favorisEntity.setIduser(Integer.valueOf(idUser));
        favorisEntity.setAnnonceEntity(annonce);

            this.favorisService.addnewFavoris(favorisEntity);
            return ResponseEntity.ok("succes");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<String> RemoveFromfavoris(@RequestBody AnnonceEntity annonceEntity,@RequestHeader(name = "Authorization") String authHeader) throws Exception{
        try{
            String jwt = authHeader.substring(7);
            String idUser = jwtService.extractUsername(jwt);
            FavoriteEntity favoriteEntity = new FavoriteEntity();
            favoriteEntity.setIduser(Integer.valueOf(idUser));
            favoriteEntity.setAnnonceEntity(annonceEntity);
            this.favorisService.removeFromFavoris(favoriteEntity);
            return ResponseEntity.ok("succes");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }

}
