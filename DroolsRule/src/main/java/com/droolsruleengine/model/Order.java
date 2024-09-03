package com.droolsruleengine.model;


import java.time.LocalDateTime;

public class Order {

    private Long id;
    private String vehicleType;
    private double basePrice;
    private int rideHour;

    private double price;

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    // Default constructor
    public Order() {

        this.rideHour = LocalDateTime.now().getHour();
    }

    // Constructor with parameters
    public Order(Long id, double basePrice, double price) {
        this.id = id;
        this.basePrice = basePrice;
        this.price = price;
        this.vehicleType=vehicleType;

        this.rideHour = LocalDateTime.now().getHour(); // Initialize rideHour with the current hour
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public int getRideHour() {
        return rideHour;
    }

    public void setRideHour(int rideHour) {
        this.rideHour = rideHour;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Method to update rideHour with the current hour
    public void updateRideHour() {
        this.rideHour = LocalDateTime.now().getHour();
    }
}
