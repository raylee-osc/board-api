package com.boardapp.boardapi.car.repository;

import org.springframework.data.repository.CrudRepository;
import com.boardapp.boardapi.car.entity.Engine;

public interface EngineRepository extends CrudRepository<Engine, String>{
    
}
