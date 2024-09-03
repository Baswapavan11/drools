package com.droolsruleengine.model;


public class Driver {

    private Long driverId;
    private double incentive;
    private int totalRides;
    private String name;
    private double rating;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getRating() {
        return rating;
    }
    public void setRating(double rating) {
        this.rating = rating;
    }
    public Long getDriverId() {
        return driverId;
    }
    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }
    public double getIncentive() {
        return incentive;
    }
    public void setIncentive(double incentive) {
        this.incentive = incentive;
    }
    public int getTotalRides() {
        return totalRides;
    }
    public void setTotalRides(int totalRides) {
        this.totalRides = totalRides;
    }

}
