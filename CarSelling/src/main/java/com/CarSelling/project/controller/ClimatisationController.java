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

import com.CarSelling.project.entity.ClimatisationEntity;
import com.CarSelling.project.service.ClimatisationService;

@RestController
@RequestMapping(path = "/api/climatisationcontroller/", method = RequestMethod.GET)
public class ClimatisationController {
    @Autowired
    private ClimatisationService climatisationService;

    @GetMapping("/climatisations")
    public ResponseEntity<List> getAll() {
        return ResponseEntity.ok(this.climatisationService.getAllClimatisation());
    }

    @GetMapping("/climatisation/{id}")
    public ResponseEntity<List> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(this.climatisationService.getClimatisationById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addNewClimatisation(@RequestBody ClimatisationEntity climatisationEntity) {
        try {
            return ResponseEntity.ok(this.climatisationService.createNewClimatisation(climatisationEntity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updateClimatisation(@RequestBody ClimatisationEntity climatisationEntity) {
        try {
            return ResponseEntity.ok(this.climatisationService.updateClimatisation(climatisationEntity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> deleteClimatisation(@RequestBody ClimatisationEntity climatisationEntity) {
        try {
            return ResponseEntity.ok(this.climatisationService.deleteClimatisation(climatisationEntity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteClimatisationById(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(this.climatisationService.deleteClimatisationById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
