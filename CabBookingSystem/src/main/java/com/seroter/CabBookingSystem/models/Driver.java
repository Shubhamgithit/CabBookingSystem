package com.seroter.CabBookingSystem.models;

public class Driver {
    private String name;
    private String gender;
    private int age;
    private String vehicleDetails;
    private boolean available = true;
    private double[] currentLoaction;

//	Constructor

    public Driver(String name, String gender, int age, String vehicleDetails, double[] currentLoaction) {
        super();
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.vehicleDetails = vehicleDetails;
        this.available = true;
        this.currentLoaction = currentLoaction;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getVehicleDetails() {
        return vehicleDetails;
    }

    public void setVehicleDetails(String vehicleDetails) {
        this.vehicleDetails = vehicleDetails;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }


    public double[] getCurrentLoaction() {
        return currentLoaction;
    }


    public void setCurrentLoaction(double[] currentLoaction) {
        this.currentLoaction = currentLoaction;
    }







}
