package com.seroter.CabBookingSystem;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.seroter.CabBookingSystem.Exceptions.DriverRegistrationException;
import com.seroter.CabBookingSystem.Exceptions.RideNotFoundException;
import com.seroter.CabBookingSystem.Exceptions.UserRegistrationException;
import com.seroter.CabBookingSystem.Services.Implementation.DriverServiceImplementation;
import com.seroter.CabBookingSystem.Services.Implementation.RideServiceImplementation;
import com.seroter.CabBookingSystem.Services.Implementation.UserServiceImplementation;
import com.seroter.CabBookingSystem.models.Driver;
import com.seroter.CabBookingSystem.models.Ride;
import com.seroter.CabBookingSystem.models.User;

@SpringBootApplication
class CabBookingSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CabBookingSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		UserServiceImplementation userService = new UserServiceImplementation();
		DriverServiceImplementation driverService = new DriverServiceImplementation();
		RideServiceImplementation rideService = new RideServiceImplementation();

		try (Scanner scanner = new Scanner(System.in)) {
			String input;
			do {
				System.out.println("Select:");
				System.out.println("1. Add the User");
				System.out.println("2. Add the Driver");
				System.out.println("3. Find the new Ride");
				System.out.println("0. Please Exit");
				System.out.print("Please Select: ");
				input = scanner.nextLine();

				switch (input) {
					case "1":
						// Adding the user
						try {
							System.out.print("Enter your username: ");
							String username = scanner.nextLine();
							System.out.print("Enter your gender: ");
							String gender = scanner.nextLine();
							System.out.print("Enter your age: ");
							int age = scanner.nextInt();
							scanner.nextLine();
							userService.add_user(new User(username, gender, age));
						} catch (UserRegistrationException e) {
							System.out.println("Failing to add: " + e.getMessage());
						}
						break;
					case "2":
						// Adding the driver
						try {
							System.out.print("Enter driver name: ");
							String driverName = scanner.nextLine();
							System.out.print("Enter the gender: ");
							String driverGender = scanner.nextLine();
							System.out.print("Enter the age: ");
							int driverAge = scanner.nextInt();
							scanner.nextLine();
							System.out.print("Enter vehicle details: ");
							String vehicleDetails = scanner.nextLine();
							double x=0, y=0;
							boolean validLocation = false;
							do {
								try {
									System.out.print("Enter current location (x y): ");
									String[] locationInput = scanner.nextLine().split("\\s+");
									if (locationInput.length != 2) {
										throw new IllegalArgumentException("Invalid location format. Please enter coordinates in the format 'x y'.");
									}
									x = Double.parseDouble(locationInput[0]);
									y = Double.parseDouble(locationInput[1]);
									validLocation = true;
								} catch (NumberFormatException e) {
									System.out.println("Invalid coordinates. Please enter valid numerical values.");
								} catch (IllegalArgumentException e) {
									System.out.println(e.getMessage());
								}
							} while (!validLocation);
							driverService.add_driver(new Driver(driverName, driverGender, driverAge, vehicleDetails, new double[]{x, y}));
						} catch (DriverRegistrationException e) {
							System.out.println("Failed to add driver: " + e.getMessage());
						}
						break;
					case "3":
						// Finding the ride & choosing the ride
						try {
							System.out.print("Please Enter username: ");
							String usernameForRide = scanner.nextLine();
							System.out.print("Please Enter source location (x y): ");
							double sourceX = scanner.nextDouble();
							double sourceY = scanner.nextDouble();
							scanner.nextLine();
							System.out.print("Please Select destination location (x y (separated by space)): ");
							double destX = scanner.nextDouble();
							double destY = scanner.nextDouble();
							scanner.nextLine();

							List<Ride> availableRides = rideService.find_ride(usernameForRide, new double[]{sourceX, sourceY}, new double[]{destX, destY});

							if (availableRides.size() > 0) {
								System.out.println("These are the available rides:");
								for (int i = 0; i < availableRides.size(); i++) {
									Ride ride = availableRides.get(i);
									System.out.println((i + 1) + ". " + ride.getDriverName().getName());
								}

								System.out.print("Enter the number of the ride you want to choose: ");
								int rideChoice = scanner.nextInt();
								scanner.nextLine();

								if (rideChoice >= 1 && rideChoice <= availableRides.size()) {
									Ride chosenRide = availableRides.get(rideChoice - 1);
									rideService.chooseRide(usernameForRide, chosenRide.getDriverName());
									System.out.println("Ride chosen: " + chosenRide.getDriverName().getName());
								} else {
									throw new IllegalArgumentException("Invalid ride choice.");
								}
							} else {
								throw new RideNotFoundException("No ride found.");
							}
						} catch (RideNotFoundException | IllegalArgumentException e) {
							System.out.println("Failed to find/choose ride: " + e.getMessage());
						}
						break;

					case "0":

						System.out.println("Exiting...");
						break;
					default:
						System.out.println("Invalid choice.");
				}
			} while (!input.equals("0"));
		} catch (Exception e) {
			System.out.println("An error occurred: " + e.getMessage());
		}
	}
}
