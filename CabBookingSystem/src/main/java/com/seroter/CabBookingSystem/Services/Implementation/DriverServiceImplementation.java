package com.seroter.CabBookingSystem.Services.Implementation;


import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import com.seroter.CabBookingSystem.models.Driver;
import com.seroter.CabBookingSystem.Services.DriverService;
import com.seroter.CabBookingSystem.Exceptions.DriverRegistrationException;

@Service
public class DriverServiceImplementation implements DriverService {

    public static Map<String , Driver> drivers = new HashMap<>();
    @Override
    public void add_driver(Driver driver) throws DriverRegistrationException {
        // Add driver
        if(isDriverInvalid(driver)) {
            throw new DriverRegistrationException("Invalid driver Exception");
        }
        drivers.put(driver.getName(), driver);
    }

    private boolean isDriverInvalid(Driver driver) {
        return driver == null ||
                driver.getName() == null || driver.getName().isEmpty() ||
                driver.getGender() == null || driver.getGender().isEmpty() ||
                driver.getVehicleDetails() == null || driver.getVehicleDetails().isEmpty() ||
                driver.getCurrentLoaction() == null || driver.getCurrentLoaction().length == 0 ;
    }

}
