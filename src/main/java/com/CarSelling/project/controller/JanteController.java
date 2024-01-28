package com.CarSelling.project.controller;

import com.CarSelling.project.entity.JanteEntity;
import com.CarSelling.project.service.JanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/jantecontroller/",method = RequestMethod.GET)
public class JanteController {
    @Autowired
    private JanteService janteService;

    @GetMapping("/jantes")
    public ResponseEntity<List> getAll() {
        return ResponseEntity.ok(this.janteService.getAllJante());
    }

    @GetMapping("/jante/{id}")
    public ResponseEntity<List> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(this.janteService.getJanteById(id));
    }
    @PostMapping("/add")
    public ResponseEntity<Object> addNewJante(@RequestBody JanteEntity janteEntity){
        try{
            return ResponseEntity.ok(this.janteService.createNewJante(janteEntity));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @PutMapping("/update")
    public ResponseEntity<Object> updateJante(@RequestBody JanteEntity janteEntity){
        try{
            return ResponseEntity.ok(this.janteService.updateJante(janteEntity));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @DeleteMapping("/delete")
    public ResponseEntity<Object> deleteJante(@RequestBody JanteEntity janteEntity){
        try{
            return ResponseEntity.ok(this.janteService.deleteJante(janteEntity));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteJanteById(@PathVariable Integer id){
        try{
            return ResponseEntity.ok(this.janteService.deleteJanteById(id));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
