package com.example.CarTask.Car;

import org.apache.tomcat.jni.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

//@EnableJpaRepositories
@Repository
public interface CarRepository extends JpaRepository<Car,Long> {
    List<Car> findByColor(String color);
}
