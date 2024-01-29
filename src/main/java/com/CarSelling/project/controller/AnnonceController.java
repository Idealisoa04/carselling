package com.CarSelling.project.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;

import com.CarSelling.project.Config.JwtService;
import com.CarSelling.project.entity.AnnonceEntity;
import com.CarSelling.project.service.AnnonceService;
import com.CarSelling.project.tools.FileUploader;

@RestController
@RequestMapping(path = "/api/annoncecontroller", method = RequestMethod.GET)
public class AnnonceController {

    @Autowired
    private AnnonceService annonceService;

    @Autowired
    private JwtService jwtService;

    @GetMapping("/annonce/{id}")
    public ResponseEntity<List> getById(@PathVariable ObjectId id) {
        return ResponseEntity.ok(this.annonceService.getAnnonceById(id));
    }

    @GetMapping("/annonces")
    public ResponseEntity<List> getAll() {
        return ResponseEntity.ok(this.annonceService.getAllAnnonce());
    }

    @GetMapping("/annonces/statut/{statut}") // pour recuperer si vendu ou non 0:non 1:oui
    public ResponseEntity<List> getAllByStatut(@PathVariable Integer statut) {
        return ResponseEntity.ok(this.annonceService.getAnnonceByStatut(statut));
    }

    @GetMapping("/annonces/etat/{etat}") // pour recuperer si valider ou non 0:non 1:oui
    public ResponseEntity<List> getAllByEtat(@PathVariable Integer etat) {
        return ResponseEntity.ok(this.annonceService.getAnnonceByEtat(etat));
    }

    @PostMapping(path = "/add", consumes = "application/json")
    public ResponseEntity<Object> addNewAnnonce(@RequestBody AnnonceEntity annonceEntity,@RequestHeader(name = "Authorization") String authHeader) throws Exception{
        try{
            String jwt = authHeader.substring(7);
            String idUser = jwtService.extractUsername(jwt);
            
            annonceEntity.setId_user(Integer.valueOf(idUser));

            LocalDateTime currentDateTime = LocalDateTime.now();
            annonceEntity.setDate(currentDateTime);
            FileUploader fileUploader = new FileUploader();
            List<String> urls = new ArrayList();
            String url = null;
            if(annonceEntity.getPhotos() != null) {
            for (String s : annonceEntity.getPhotos()) {
                    s = s.split("data:image/jpeg;base64,")[1];
                    // System.out.println(s);
                    url = fileUploader.uploadImage(s);
                    System.out.println(url + " url");
                    urls.add(url);
                }
                annonceEntity.setPhotos(urls);
        }
            annonceEntity.setEtat(0);
            return ResponseEntity.ok(this.annonceService.createAnnonce(annonceEntity));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }

    @PutMapping("/update")
    public ResponseEntity<Object> updateAnnonce(@RequestBody AnnonceEntity entity) throws Exception {

        try {
            return ResponseEntity.ok(this.annonceService.updateAnnonce(entity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAnnonce(@PathVariable ObjectId id) {
        try {
            return ResponseEntity.ok(this.annonceService.deleteAnnonceById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteAnnonce(@RequestBody AnnonceEntity annonce) {
        try {
            return ResponseEntity.ok(this.annonceService.deleteAnnonce(annonce));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/updateEtat") // valider ou pas
    public ResponseEntity<String> updateEtat(HttpServletRequest req) {

        try {
            ObjectId id = new ObjectId(req.getParameter("id"));
            Integer etat = Integer.valueOf(req.getParameter("etat"));

            return ResponseEntity.ok(this.annonceService.updateEtat(id, etat));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }


    @PutMapping("/updateStatut") // vendu ou pas
    public ResponseEntity<String> updateStatut(@RequestParam("id") ObjectId id,
            @RequestParam("statut") Integer statut,@RequestParam("commission") Double commission) {
        try {
            return ResponseEntity.ok(this.annonceService.updateStatut(id, statut, commission));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }

    @GetMapping("/historique")
    public ResponseEntity<List<AnnonceEntity>> findHistorique(@RequestHeader(name = "Authorization") String authHeader) throws Exception{
        try{
            String jwt = authHeader.substring(7);
            String idUser = jwtService.extractUsername(jwt);
            return ResponseEntity.ok(this.annonceService.findHistorique(Integer.valueOf(idUser)));
        }catch(Exception e){
            throw e;
        }
    }

}
