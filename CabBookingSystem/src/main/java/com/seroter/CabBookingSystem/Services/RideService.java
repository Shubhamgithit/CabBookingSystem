package com.seroter.CabBookingSystem.Services;

import java.util.List;
import com.seroter.CabBookingSystem.models.Driver;
import com.seroter.CabBookingSystem.models.Ride;

public interface RideService {
    public List<Ride> find_ride(String username , double[] source , double[] destination);
    public void chooseRide(String username, Driver driver);
}