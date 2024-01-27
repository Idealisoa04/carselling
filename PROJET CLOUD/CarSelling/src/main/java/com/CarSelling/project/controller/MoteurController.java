package com.CarSelling.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CarSelling.project.entity.MoteurEntity;
import com.CarSelling.project.service.MoteurService;

@RestController
@RequestMapping(path = "/api/moteurcontroller")
public class MoteurController {
    @Autowired
    private MoteurService moteurService;

    @GetMapping("/moteurs")
    public ResponseEntity<List> getAll() {
        return ResponseEntity.ok(this.moteurService.getAllMoteur());
    }

    @GetMapping("/moteur/{id}")
    public ResponseEntity<List> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(this.moteurService.getMoteurById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addNewmoteur(@RequestBody MoteurEntity moteurEntity) {
        try {

            return ResponseEntity.ok(this.moteurService.createNewMoteur(moteurEntity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.OK).body(e.getMessage());
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updatemoteur(@RequestBody MoteurEntity moteurEntity) {
        try {
            return ResponseEntity.ok(this.moteurService.updateMoteur(moteurEntity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> deletemoteur(@RequestBody MoteurEntity moteurEntity) {
        try {
            return ResponseEntity.ok(this.moteurService.deleteMoteur(moteurEntity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deletemoteurById(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(this.moteurService.deleteMoteurById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
