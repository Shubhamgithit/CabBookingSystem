The Cab Booking System is a command-line application designed to facilitate ride bookings along specific routes. It empowers users to register, enables drivers to enlist with their vehicle particulars, and facilitates users in searching and choosing rides from a pool of available options, tailored to their source and destination.

**Key Features:**

- User Registration: Users can sign up for the service, creating their own profiles.
- Driver Onboarding: Drivers have the capability to join the system by providing their vehicle details.
- Ride Search and Selection: Users can explore and opt for rides that align with their travel needs, considering the source and destination.
- Ride Choice: From the available ride options, users have the freedom to select the most suitable one.

**Example scenario:**

1. Onboard 3 users
    add_user(“Abhishek, M, 23”); 
    add_user(“Rahul , M, 29”); 
    add_user(“Nandini, F, 22”) ;

2. Onboard 3 driver to the application
    add_driver(“Driver1, M, 22”,“Swift, KA-01-12345”,(10,1))
    add_driver(“Driver2, M, 29”,“Swift, KA-01-12345”,(11,10))
    add_driver(“Driver3, M, 24”,“Swift, KA-01-12345”,(5,3))
    	
3. User trying to get a ride 
    find_ride(“Abhishek” ,(0,0),(20,1))
    		Output : No ride found [Since all the driver are more than 5 units away from user]
    find_ride(“Rahul” ,(10,0),(15,3))
    		Output : Driver1 [Available]
    find_ride(“Nandini”,(15,6),(20,4))
    Output : No ride found [Driver one in set to not available]
