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

    public Car saveCar(Car dto) {
        return this.carRepository.save(dto);
    }

    public Engine saveEngine(Engine dto) {
        dto.setNew(true);

        return this.engineRepository.save(dto);
    }

    public Car update(Long carId, Car dto){
        dto.setCarId(carId);

        return this.carRepository.save(dto);
    }

    public Engine updateEngine(String engineName, Engine dto) {
        dto.setEngineName(engineName);

        return this.engineRepository.save(dto);
    }

    public void deleteCar(Long carId) {
        this.carRepository.deleteById(carId);
    }

    public void deleteEngine(String engineName){
        this.engineRepository.deleteById(engineName);
    }
}
