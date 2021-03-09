package com.example.demo.controller;

import com.example.demo.entities.MyEntity;
import com.example.demo.service.MyEntitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/demo")
public class HelloWorldController {
    @Autowired
    private MyEntitiesService myEntitiesService;

    @GetMapping("/hello-world")
    public ResponseEntity<String> helloWorld(){
        return new ResponseEntity<>("HELLO-WORLD", HttpStatus.OK);
    }

    @GetMapping("/find-by-name/{name}")
    public ResponseEntity<List<MyEntity>> getEntitiesByName(@PathVariable String name){
        return new ResponseEntity<>(myEntitiesService.getEntitiesByName(name),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MyEntity> getEntityById(@PathVariable Integer id){
        return new ResponseEntity<>(myEntitiesService.getEntityById(id),HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<MyEntity>> getAllEntities(){
        return new ResponseEntity<>(myEntitiesService.getAllEntities(),HttpStatus.OK);
    }

    @PostMapping("/create-entity")
    public ResponseEntity<?> createEntity (@RequestBody MyEntity myEntity) {
        myEntitiesService.addNewEntity(myEntity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update-entity/{id}")
    public ResponseEntity<?> updateEntity (@PathVariable Integer id,@RequestBody MyEntity myEntity) {
        myEntitiesService.updateEntity(id, myEntity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete-entity/{id}")
    public ResponseEntity<?> deleteEntity (@PathVariable Integer id) {
        myEntitiesService.deleteEntity(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
