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

    @GetMapping(headers = "searchKey=car")
    public Iterable<Car> findAllCars() {
        return this.carService.findAllCars();
    }

    @GetMapping(headers = "searchKey=engine")
    public Iterable<Engine> findAllEngines() {
        return this.carService.findAllEngines();
    }

    @GetMapping(value = "/:{carId}",headers = "searchKey=car")
    public Car findByCarId(@PathVariable Long carId) {
        return this.carService.findByCarId(carId);
    }

    @GetMapping(value = "/:{engineName}",headers = "searchKey=engine")
    public Engine findByEngineName(@PathVariable String engineName) {
        return this.carService.findByEngineName(engineName);
    }

    @PostMapping(headers = "searchKey=car")
    public Car saveCar(@RequestBody Car dto) {
        return this.carService.saveCar(dto);
    }

    @PostMapping(headers = "searchKey=engine")
    public Engine saveEngine(@RequestBody Engine dto){
        return this.carService.saveEngine(dto);
    }

    @PutMapping(value = "/:{carId}",headers = "searchKey=car")
    public Car updateCar(@PathVariable Long carId, @RequestBody Car dto) {
        return this.carService.update(carId, dto);
    }

    @PutMapping(value = "/:{engineName}",headers = "searchKey=engine")
    public Engine updatEngine(@PathVariable String engineName, @RequestBody Engine dto){
        return this.updatEngine(engineName, dto);
    }

    @DeleteMapping(value = "/:{carId}",headers = "searchKey=car")
    public void deleteCar(@PathVariable Long carId) {
        this.carService.deleteCar(carId);
    }

    @DeleteMapping(value = "/:{engineName}",headers = "searchKey=engine")
    public void deleteEngine(@PathVariable String engineName){
        this.carService.deleteEngine(engineName);
    }
}
