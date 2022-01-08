package com.example.CarTask.Car;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private int yearOfMake;
    private String color;
    private int price;
    private int numSearch;

    public Car() {}


    public Car(Long id, String model, int yearOfMake, String color, int price, int numSearch) {
        this.id = id;
        this.model = model;
        this.yearOfMake = yearOfMake;
        this.color = color;
        this.price = price;
        this.numSearch = numSearch;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYearOfMake() {
        return yearOfMake;
    }

    public void setYearOfMake(int yearOfMake) {
        this.yearOfMake = yearOfMake;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumSearch() {
        return numSearch;
    }

    public void setNumSearch(int numSearch) {
        this.numSearch = numSearch;
    }
}
