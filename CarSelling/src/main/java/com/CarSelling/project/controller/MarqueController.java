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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.CarSelling.project.entity.MarqueEntity;
import com.CarSelling.project.service.MarqueService;

@RestController
@RequestMapping(path = "/api/marquecontroller", method = RequestMethod.GET)
public class MarqueController {
    @Autowired
    private MarqueService marqueService;

    @GetMapping("/marques")
    public ResponseEntity<List<MarqueEntity>> getAll() {
        return ResponseEntity.ok(this.marqueService.getAllMarque());
    }

    @GetMapping("/marque/{id}")
    public ResponseEntity<List> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(this.marqueService.getMarqueById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addNewMarque(@RequestBody MarqueEntity marqueEntity) {
        try {
            return ResponseEntity.ok(this.marqueService.createNewMarque(marqueEntity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updateMarque(@RequestBody MarqueEntity marqueEntity) {
        try {
            return ResponseEntity.ok(this.marqueService.updateMarque(marqueEntity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> deleteMarque(@RequestBody MarqueEntity marqueEntity) {
        try {
            return ResponseEntity.ok(this.marqueService.deleteMarque(marqueEntity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteMarqueById(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(this.marqueService.deleteMarqueById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
