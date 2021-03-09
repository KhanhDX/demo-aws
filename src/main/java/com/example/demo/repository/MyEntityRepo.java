package com.example.demo.repository;

import com.example.demo.entities.MyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyEntityRepo extends JpaRepository<MyEntity, Integer> {
    List<MyEntity> findMyEntitiesByName (String name);
    MyEntity findMyEntityById(Integer id);
}
