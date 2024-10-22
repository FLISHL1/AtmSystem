package ru.flish1.atmsystem.services;


import org.flishl1.entity.User;

import java.util.Optional;

public class AuthService {
    private final UserService userService = new UserService();

    public User signUpUser(String firstName, String lastName, String secondName,
                           Integer seriesPassport, Integer numberPassport) {
        Optional<User> user = userService.getByPassport(seriesPassport, numberPassport);
        return user.orElseGet(() ->
                userService.createUser(firstName, lastName, secondName, seriesPassport, numberPassport
                ));
    }


}
