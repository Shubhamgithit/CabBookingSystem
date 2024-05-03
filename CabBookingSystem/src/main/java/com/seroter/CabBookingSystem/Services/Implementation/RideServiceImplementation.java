package com.seroter.CabBookingSystem.Services.Implementation;

import java.util.ArrayList;
import java.util.List;
import com.seroter.CabBookingSystem.Services.RideService;
import com.seroter.CabBookingSystem.models.Ride;
import com.seroter.CabBookingSystem.models.Driver;

public class RideServiceImplementation implements RideService {

    private int MAX_DISTANCE_THRESHOLD = 5;
    @Override
    public List<Ride> find_ride(String username, double[] source, double[] destination) {
        List<Ride> availableRides = new ArrayList<>();
        try {
            for (Driver driver : DriverServiceImplementation.drivers.values()) {
                if (driver.isAvailable()) {
                    double distance = calculateDistance(source, driver.getCurrentLoaction());
                    if (distance <= MAX_DISTANCE_THRESHOLD) {
                        Ride ride = new Ride(driver, source, destination);
                        availableRides.add(ride);
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while finding rides: " + e.getMessage());
        }
        return availableRides;
    }

    @Override
    public void chooseRide(String username, Driver driver) {
        try {
            driver.setAvailable(false);
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while choosing ride: " + e.getMessage());
        }
    }

    private double calculateDistance(double[] location1, double[] location2) {
        double x = Math.abs(location2[0] - location1[0]);
        double y = Math.abs(location2[1] - location1[1]);
        return x + y;
    }
}
