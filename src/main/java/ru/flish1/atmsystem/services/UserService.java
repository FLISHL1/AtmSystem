package ru.flish1.atmsystem.services;


import org.flishl1.entity.User;
import org.flishl1.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class UserService {
    private final UserRepository userRepository = new UserRepository();
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public User createUser(String firstName, String lastName, String secondName,
                           Integer seriesPassport, Integer numberPassport) {
        User newUser = new User();
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        if (!secondName.isBlank())
            newUser.setSecondName(secondName);
        newUser.getProfile().setNumberPassport(numberPassport);
        newUser.getProfile().setSerialPassport(seriesPassport);

        newUser = userRepository.save(newUser);
        logger.info("New user save into Data Base {}", newUser);
        return newUser;
    }

    public Optional<User> getByPassport(Integer seriesPassport, Integer numberPassport) {
        return Optional.ofNullable(userRepository.findBySerialPassportAndNumberPassport(seriesPassport, numberPassport));
    }

    public User getById(Long id) {
        return userRepository.findById(id);
    }

    public boolean removeById(Long id) {
        return userRepository.remove(id);
    }
}
