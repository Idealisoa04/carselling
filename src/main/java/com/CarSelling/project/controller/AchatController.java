package com.CarSelling.project.controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.CarSelling.project.entity.AchatEntity;
import com.CarSelling.project.service.AchatService;
import com.CarSelling.project.service.AnnonceService;

@RestController
@RequestMapping(path = "/api/achatcontroller", method = RequestMethod.GET)
public class AchatController {
    @Autowired
    private AchatService achatService;
    @Autowired
    private AnnonceService annonceService;

    @GetMapping(path = "/vendu/{idannonce}")
    @Transactional
    public ResponseEntity<String> addNewAchat(@PathVariable String idannonce) {
        AchatEntity achatEntity = new AchatEntity();
        achatEntity.setIdannonce(idannonce);
        try {
            this.achatService.addNewAchat(achatEntity);
            this.annonceService.updateStatut(new ObjectId(idannonce), 1,20.0);
            return ResponseEntity.ok("ok");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }
}
