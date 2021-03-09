package com.example.demo.service;

import com.example.demo.entities.MyEntity;
import com.example.demo.repository.MyEntityRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface MyEntitiesService {
    List<MyEntity> getAllEntities();
    MyEntity getEntityById(Integer id);
    List<MyEntity> getEntitiesByName(String name);
}
