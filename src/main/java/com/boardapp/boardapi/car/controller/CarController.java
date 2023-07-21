package com.boardapp.boardapi.car.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.boardapp.boardapi.car.entity.Car;
import com.boardapp.boardapi.car.entity.Engine;
import com.boardapp.boardapi.car.service.CarService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("cars")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @GetMapping
    public Iterable<Car> findAllCars() {
        return this.carService.findAllCars();
    }

    @GetMapping
    public Iterable<Engine> findAllEngines() {
        return null;
    }

    @GetMapping("/:{carId}")
    public Car findByCarId(@PathVariable Long carId) {
        return this.carService.findByCarId(carId);
    }

    @GetMapping("/:{engineName}")
    public Engine findByEngineName(@PathVariable String engineName) {
        return null;
    }

    @PostMapping
    public Car saveCar(@RequestBody Car dto) {
        return this.carService.save(dto);
    }

    @PutMapping("/:{carId}")
    public Car updateCar(@PathVariable Long carId, @RequestBody Car dto) {
        return this.carService.update(carId, dto);
    }

    @DeleteMapping("/:{carId}")
    public void deleteCar(@PathVariable Long carId) {
        this.carService.delete(carId);
    }
}
