package ru.flish1.atmsystem.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jline.terminal.Terminal;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.flish1.atmsystem.dto.UserDto;
import ru.flish1.atmsystem.entity.Profile;
import ru.flish1.atmsystem.service.AuthorizationService;

@ShellComponent
@RequiredArgsConstructor
@Slf4j
public class AuthorizationShellController {
    private final Terminal terminal;
    private final AuthorizationService authorizationService;

    @ShellMethod(value = "Регистрирует нового пользователя")
    private void registrationUser(
            @ShellOption(help = "Номер паспорта", value = {"--np"})
            String numberPassport,
            @ShellOption(help = "Серия паспорта", value = {"--sp"})
            String seriesPassport,
            @ShellOption(help = "Имя клиента", value = {"--fn"})
            String firstName,
            @ShellOption(help = "Фамилия клиента", value = {"--ln"})
            String lastName,
            @ShellOption(help = "Отчество клиента", value = {"--sn"}, defaultValue = ShellOption.NULL)
            String secondName
    ) {
        UserDto userDto = UserDto.builder()
                .firstName(firstName)
                .lastName(lastName)
                .secondName(secondName)
                .profile(Profile.builder()
                        .seriesPassport(seriesPassport)
                        .numberPassport(numberPassport)
                        .build())
                .build();
        userDto = authorizationService.registerUser(userDto);
        terminal.writer().println("Пользователь создан");
        terminal.writer().println(userDto);
    }
}
