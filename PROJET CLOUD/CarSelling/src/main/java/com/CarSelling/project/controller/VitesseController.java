package com.CarSelling.project.controller;

import com.CarSelling.project.entity.VitesseEntity;
import com.CarSelling.project.service.VitesseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/vitessecontroller/",method = RequestMethod.GET)
public class VitesseController {
    @Autowired
    private VitesseService vitesseService;

    @GetMapping("/vitesses")
    public ResponseEntity<List> getAll() {
        return ResponseEntity.ok(this.vitesseService.getAllVitesse());
    }

    @GetMapping("/vitesse/{id}")
    public ResponseEntity<List> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(this.vitesseService.getVitesseById(id));
    }
    @PostMapping("/add")
    public ResponseEntity<Object> addNewVitesse(@RequestBody VitesseEntity vitesseEntity){
        try{
            return ResponseEntity.ok(this.vitesseService.createNewVitesse(vitesseEntity));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @PutMapping("/update")
    public ResponseEntity<Object> updateVitesse(@RequestBody VitesseEntity vitesseEntity){
        try{
            return ResponseEntity.ok(this.vitesseService.updateVitesse(vitesseEntity));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @DeleteMapping("/delete")
    public ResponseEntity<Object> deleteVitesse(@RequestBody VitesseEntity vitesseEntity){
        try{
            return ResponseEntity.ok(this.vitesseService.deleteVitesse(vitesseEntity));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteVitesseById(@PathVariable Integer id){
        try{
            return ResponseEntity.ok(this.vitesseService.deleteVitesseById(id));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
