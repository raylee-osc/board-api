package com.boardapp.boardapi.car.service;

import org.springframework.stereotype.Service;
import com.boardapp.boardapi.car.entity.Car;
import com.boardapp.boardapi.car.entity.Engine;
import com.boardapp.boardapi.car.repository.CarRepository;
import com.boardapp.boardapi.car.repository.EngineRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;
    private final EngineRepository engineRepository;

    public Iterable<Car> findAllCars() {
        return this.carRepository.findAll();
    }

    public Iterable<Engine> findAllEngines() {
        return this.engineRepository.findAll();
    }

    public Car findByCarId(Long carId) {
        return this.carRepository.findById(carId).get();
    }

    public Engine findByEngineName(String engineName){
        return this.engineRepository.findById(engineName).get();
    }

    public Car save(Car dto) {
        return this.carRepository.save(dto);
    }

    public Car update(Long carId, Car dto){
        dto.setCarId(carId);

        return this.carRepository.save(dto);
    }

    public void delete(Long carId) {
        this.carRepository.deleteById(carId);
    }
}
