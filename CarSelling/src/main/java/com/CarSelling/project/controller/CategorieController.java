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

import com.CarSelling.project.entity.CategorieEntity;
import com.CarSelling.project.service.CategorieService;

@RestController
@RequestMapping(path = "/api/categoriecontroller", method = RequestMethod.GET)
public class CategorieController {
    @Autowired
    private CategorieService categorieService;

    @GetMapping("/categories")
    public ResponseEntity<List> getAll() {
        return ResponseEntity.ok(this.categorieService.getAllCategorie());
    }

    @GetMapping("/categorie/{id}")
    public ResponseEntity<List> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(this.categorieService.getCategorieById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addNewCategorie(@RequestBody CategorieEntity categorieEntity) {
        try {
            return ResponseEntity.ok(this.categorieService.createNewCategorie(categorieEntity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updateCategorie(@RequestBody CategorieEntity categorieEntity) {
        try {
            return ResponseEntity.ok(this.categorieService.updateCategorie(categorieEntity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> deleteCategorie(@RequestBody CategorieEntity categorieEntity) {
        try {
            return ResponseEntity.ok(this.categorieService.deleteCategorie(categorieEntity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteCategorieById(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(this.categorieService.deleteCategorieById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
