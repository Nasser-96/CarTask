package com.example.CarTask.Car;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("car")
public class CarController {

    @Autowired
    private final CarService carService;


    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<Car> getCars(){
        return carService.getAllCars();
    }

    @PostMapping
    public ResponseEntity<String> saveCar(@RequestBody Car car){
        return carService.saveCar(car);
    }

    @GetMapping("/{color}")
    public ResponseEntity<?> getByColor(@PathVariable String color){
        return carService.getByColor(color);
    }

    @GetMapping("/year")
    public ResponseEntity<?> getByYear(@RequestBody Car car){
        return carService.getCarByYear(car.getNumSearch());
    }

    @GetMapping("/price")
    public ResponseEntity<?> getByPrice(@RequestBody Car car){
        return carService.getByPrice(car);
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> sellCar(@PathVariable String id, @RequestBody Car car){
        return carService.sellCar(id,car.getNumSearch());
    }

    @DeleteMapping
    public ResponseEntity<?> deleteOldCars(){
        return carService.deleteOldCars();
    }
}
