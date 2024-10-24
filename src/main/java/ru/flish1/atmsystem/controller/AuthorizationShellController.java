package ru.flish1.atmsystem.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jline.terminal.Terminal;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.flish1.atmsystem.dto.AccountRegisterDto;
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
            @ShellOption(help = "Номер паспорта", value = {"--np", "--numberPassport"})
            String numberPassport,
            @ShellOption(help = "Серия паспорта", value = {"--sp", "--seriesPassport"})
            String seriesPassport,
            @ShellOption(help = "Имя клиента", value = {"--fn"})
            String firstName,
            @ShellOption(help = "Фамилия клиента", value = {"--ln"})
            String lastName,
            @ShellOption(help = "Отчество клиента", value = {"--sn"}, defaultValue = ShellOption.NULL)
            String secondName
    ) {
        UserDto userDto = new UserDto(
                firstName,
                lastName,
                secondName,
                Profile.builder()
                        .numberPassport(numberPassport)
                        .seriesPassport(seriesPassport)
                        .build());
        userDto = authorizationService.registerUser(userDto);
        terminal.writer().println("Пользователь создан");
        terminal.writer().println(userDto);
    }

    @ShellMethod(value = "Регистрирует новый счет")
    private void registrationAccount(
            @ShellOption(help = "Номер паспорта клиента", value = {"--np", "--numberPassport"})
            String numberPassport,
            @ShellOption(help = "Серия паспорта клиента", value = {"--sp", "--seriesPassport"})
            String seriesPassport,
            @ShellOption(help = "Название банка где открывается счет", value = {"-b", "--bank"})
            String bankTitle,
            @ShellOption(help = "Наименование счета", value = {"--ta", "--titleAccount"})
            String titleAccount,
            @ShellOption(help = "Пин код счета", value = {"-p", "--pinCode"})
            String pinCode
    ) {
        AccountRegisterDto accountDto = new AccountRegisterDto(
                titleAccount,
                Profile.builder()
                        .numberPassport(numberPassport)
                        .seriesPassport(seriesPassport)
                        .build(),
                pinCode,
                bankTitle
        );
        terminal.writer().println(authorizationService.registerAccount(accountDto));
    }
}
