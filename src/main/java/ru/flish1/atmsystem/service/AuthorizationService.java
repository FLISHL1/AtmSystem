package ru.flish1.atmsystem.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.flish1.atmsystem.dto.AccountRegisterDto;
import ru.flish1.atmsystem.dto.UserDto;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthorizationService {
    private final UserService userService;
    private final AccountService accountService;

    public UserDto registerUser(UserDto userDto){
        log.info("Начинается создание пользователя: \n{}", userDto);

        return userService.create(userDto);
    }

    public AccountRegisterDto registerAccount(AccountRegisterDto accountDto) {
        log.info("Начинатся регистрация счета \n{}", accountDto);

        return accountService.create(accountDto);
    }
}
