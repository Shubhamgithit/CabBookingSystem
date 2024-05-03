package com.seroter.CabBookingSystem.Services.Implementation;

import java.util.HashMap;
import java.util.Map;
import com.seroter.CabBookingSystem.Exceptions.UserRegistrationException;
import com.seroter.CabBookingSystem.Services.UserService;
import com.seroter.CabBookingSystem.models.User;

public class UserServiceImplementation implements UserService {

    public Map<String , User> users = new HashMap<>();

    @Override
    public void add_user(User user) throws UserRegistrationException {
        // TODO Auto-generated method stub
        if (isUserInvalid(user)) {
            throw new UserRegistrationException("Invalid user information");
        }
        users.put(user.getUsernmae(), user);
    }

    private boolean isUserInvalid(User user) {
        return user == null ||
                user.getUsernmae() == null || user.getUsernmae().isEmpty() ||
                user.getGender() == null || user.getGender().isEmpty() ||
                user.getAge() == -1;
    }

}

