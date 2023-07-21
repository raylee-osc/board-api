package com.boardapp.boardapi.car.repository;

import org.springframework.data.repository.CrudRepository;
import com.boardapp.boardapi.car.entity.Car;

public interface CarRepository extends CrudRepository<Car, Long>{
    
}
