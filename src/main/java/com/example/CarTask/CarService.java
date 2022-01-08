package com.example.CarTask;


import com.example.CarTask.Car.Car;
import com.example.CarTask.Car.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;



    public List<Car> getAllCars(){
        return carRepository.findAll();
    }

    public ResponseEntity<String> saveCar(Car car){
        carRepository.save(car);
        return ResponseEntity.ok("Car Created Correctly");
    }

    public ResponseEntity<?> getCarByYear(int year){
        List <Car> result = carRepository.findAll();

        for (int i = 0; i < result.size(); i++) {
            if (year> result.get(i).getYearOfMake()){
                result.remove(i);
            }
        }
        if (result.size()>0){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.status(400).body("We did not Find what you looking for");
    }

    public ResponseEntity<?> getByColor(String color){
        return ResponseEntity.ok(carRepository.findByColor(color));
    }

    public ResponseEntity<?> getByPrice(Car car){
        List<Car> result = carRepository.findAll();
        ArrayList <Car> newArray = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i).getPrice()<=car.getPrice()){
                newArray.add(result.get(i));
            }
        }
        if (newArray.size()<1){
            return ResponseEntity.status(400).body("We did not Find what you looking for");
        }
            return ResponseEntity.ok(newArray);


    }

    public ResponseEntity<?> sellCar(String id , int price){
        Long car_id = Long.parseLong(id);
        Car FoundCar = carRepository.findById(car_id).orElse(null);
        if (FoundCar == null){
            return ResponseEntity.status(400).body("The Car you are looking for it does not exist");
        }
        if (price<FoundCar.getPrice()){
            return ResponseEntity.status(400).body("Your money is not enough");
        }
        int leftMoney = price - FoundCar.getPrice();
        carRepository.deleteById(car_id);
        return ResponseEntity.ok("Congratulation you buy the car and here what left of your money: "+leftMoney);
    }

    public ResponseEntity<?> deleteOldCars(){
        List<Car> result = carRepository.findAll();

        for (int i = 0; i < result.size(); i++) {
            if (result.get(i).getYearOfMake()<2017){
                carRepository.deleteById(result.get(i).getId());
            }
        }
        return ResponseEntity.ok(carRepository.findAll());
    }
}
