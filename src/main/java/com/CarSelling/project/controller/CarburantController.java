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

import com.CarSelling.project.entity.CarburantEntity;
import com.CarSelling.project.service.CarburantService;

@RestController
@RequestMapping(path = "/api/carburantcontroller", method = RequestMethod.GET)
public class CarburantController {
    @Autowired
    private CarburantService carburantService;

    @GetMapping("/carburants")
    public ResponseEntity<List> getAll() {
        return ResponseEntity.ok(this.carburantService.getAllCarburant());
    }

    @GetMapping("/carburant/{id}")
    public ResponseEntity<List> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(this.carburantService.getCarburantById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addNewCarburant(@RequestBody CarburantEntity carburantEntity) {
        try {
            return ResponseEntity.ok(this.carburantService.createNewCarburant(carburantEntity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updateCarburant(@RequestBody CarburantEntity carburantEntity) {
        try {
            return ResponseEntity.ok(this.carburantService.updateCarburant(carburantEntity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> deleteCarburant(@RequestBody CarburantEntity carburantEntity) {
        try {
            return ResponseEntity.ok(this.carburantService.deleteCarburant(carburantEntity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteCarburantById(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(this.carburantService.deleteCarburantById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
