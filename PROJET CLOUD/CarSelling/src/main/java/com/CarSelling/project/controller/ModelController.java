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

import com.CarSelling.project.entity.ModelEntity;
import com.CarSelling.project.entity.VModelEntity;
import com.CarSelling.project.service.ModelService;

@RestController
@RequestMapping(path = "/api/modelcontroller", method = RequestMethod.GET)
public class ModelController {
    @Autowired
    private ModelService modelService;

    @GetMapping("/models")
    public ResponseEntity<List<VModelEntity>> getAll() {
        return ResponseEntity.ok(this.modelService.getAllModel());
    }

    @GetMapping("/model/{id}")
    public ResponseEntity<List> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(this.modelService.getModelById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addNewModel(@RequestBody ModelEntity modelentity) {
        try {
            // System.out.println(modelEntity.getMarque().getIdmarque());
            return ResponseEntity.ok(this.modelService.createNewModel(modelentity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updateModel(@RequestBody ModelEntity modelEntity) {
        try {
            return ResponseEntity.ok(this.modelService.updateModel(modelEntity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> deleteModel(@RequestBody ModelEntity modelEntity) {
        try {
            return ResponseEntity.ok(this.modelService.deleteModel(modelEntity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteModelById(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(this.modelService.deleteModelById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
