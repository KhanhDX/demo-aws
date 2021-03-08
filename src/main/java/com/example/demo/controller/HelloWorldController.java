package com.example.demo.controller;

import com.example.demo.entities.MyEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin("*")
public class HelloWorldController {
    private MyEntity entity;

    @GetMapping("/hello-world")
    public ResponseEntity<List<MyEntity>> helloWorld(){
        entity = new MyEntity("HELLO-WORLD");
        List<MyEntity> myEntities = Arrays.asList(entity);
        return new ResponseEntity<>(myEntities, HttpStatus.OK);
    }
}
