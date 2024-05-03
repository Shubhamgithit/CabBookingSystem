package com.seroter.CabBookingSystem.models;

public class Ride {
    private Driver driverName;
    private double[] source;
    private double[] destination;

    public Ride(Driver driverName, double[] source, double[] destination) {
        super();
        this.driverName = driverName;
        this.source = source;
        this.destination = destination;
    }

    public Driver getDriverName() {
        return driverName;
    }

    public void setDriverName(Driver driverName) {
        this.driverName = driverName;
    }

    public double[] getSource() {
        return source;
    }

    public void setSource(double[] source) {
        this.source = source;
    }

    public double[] getDestination() {
        return destination;
    }

    public void setDestination(double[] destination) {
        this.destination = destination;
    }





}

