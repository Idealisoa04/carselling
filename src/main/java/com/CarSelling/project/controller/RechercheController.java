package com.CarSelling.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.CarSelling.project.model.Recherchemodel;
import com.CarSelling.project.service.RerchercheService;

@RestController
@RequestMapping(path = "/api/recherchecontroller", method = RequestMethod.GET)
public class RechercheController {
    @Autowired
    private RerchercheService rerchercheService;

    @PostMapping(path = "/search", consumes = "application/json")
    public ResponseEntity<Object> search(@RequestBody Recherchemodel recherche) {
        try {
            System.out
                    .println(recherche.getIdCategorie() + " " + recherche.getIdMarque() + " " + recherche.getIdModel());
            // return ResponseEntity.ok("hey");
            return ResponseEntity.ok(rerchercheService.getAllAnnonce(recherche));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }
}
