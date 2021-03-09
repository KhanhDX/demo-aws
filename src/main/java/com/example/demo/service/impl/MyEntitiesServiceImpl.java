package com.example.demo.service.impl;

import com.example.demo.entities.MyEntity;
import com.example.demo.repository.MyEntityRepo;
import com.example.demo.service.MyEntitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyEntitiesServiceImpl implements MyEntitiesService {
    @Autowired
    private MyEntityRepo myEntityRepo;

    @Override
    public List<MyEntity> getAllEntities() {
        return myEntityRepo.findAll();
    }

    @Override
    public MyEntity getEntityById(Integer id) {
        return myEntityRepo.findMyEntityById(id);
    }

    @Override
    public List<MyEntity> getEntitiesByName(String name) {
        return myEntityRepo.findMyEntitiesByName(name);
    }

    @Override
    public void addNewEntity(MyEntity myEntity) {
        myEntityRepo.save(myEntity);
    }

    @Override
    public void updateEntity(Integer id, MyEntity newEntity) {
        MyEntity currEntity = myEntityRepo.findMyEntityById(id);

        currEntity.setName(newEntity.getName());
        currEntity.setAge(newEntity.getAge());

        myEntityRepo.save(currEntity);
    }

    @Override
    public void deleteEntity(Integer id) {
        myEntityRepo.deleteById(id);
    }
}
