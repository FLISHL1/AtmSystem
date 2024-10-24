package ru.flish1.atmsystem.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.flish1.atmsystem.dto.UserDto;
import ru.flish1.atmsystem.entity.User;
import ru.flish1.atmsystem.exception.UserNotFoundException;
import ru.flish1.atmsystem.mapper.UserDtoMapper;
import ru.flish1.atmsystem.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    private final UserDtoMapper userDtoMapper;

    @Transactional
    public UserDto create(UserDto userDto){
        User user = userDtoMapper.userDtoToUser(userDto);
        log.debug("Пользователь дто смаплен \n{}", user.toString());
        user = userRepository.save(user);
        log.debug("Пользователь сохранен \n{}", user);
        return userDtoMapper.userToUserDto(user);
    }

    public List<UserDto> getAll() {
        List<User> users = userRepository.findAll();
        return userDtoMapper.usersToUsersDto(users);
    }

    public UserDto getDtoByPassport(String seriesPassport, String numberPassport) {
        User user = getByPassport(seriesPassport, numberPassport);
        return userDtoMapper.userToUserDto(user);
    }

    public User getByPassport(String seriesPassport, String numberPassport) {
        return userRepository.findByPassport(seriesPassport, numberPassport).orElseThrow(() -> {
            UserNotFoundException exception = new UserNotFoundException("Пользователь с паспортом " + seriesPassport + " " + numberPassport + " не найден");
            log.error(exception.getMessage());
            return exception;
        });
    }


    @Transactional
    public void removeByPassport(String seriesPassport, String numberPassport) {
        userRepository.deleteByPassport(seriesPassport, numberPassport);
    }
}
