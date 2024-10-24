package ru.flish1.atmsystem.controller;

import lombok.RequiredArgsConstructor;
import org.jline.terminal.Terminal;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.flish1.atmsystem.dto.UserDto;
import ru.flish1.atmsystem.service.UserService;

import java.util.List;

@ShellComponent
@RequiredArgsConstructor
public class UserShellController {
    private final Terminal terminal;
    private final UserService userService;

    @ShellMethod(value = "Получить всех пользователей", key = {"get-all-users"})
    private void getAll() {
        List<UserDto> userDtoList = userService.getAll();
        terminal.writer().println(userDtoList);
    }

    @ShellMethod(value = "Получить пользователя по паспорту", key = {"get-user-passport"})
    private void getByPassport(
            @ShellOption(help = "Серия паспорта", value = {"--serial", "-s"})
            String serial,
            @ShellOption(help = "Номер паспорта", value = {"--number", "-n"})
            String number
    ) {
        UserDto userDtoList = userService.getDtoByPassport(serial, number);
        terminal.writer().println(userDtoList);
    }
    @ShellMethod(value = "Удалить пользователя по паспорту", key = {"remove-user"})
    private void removeByPassport(
            @ShellOption(help = "Серия паспорта", value = {"--serial", "-s"})
            String serial,
            @ShellOption(help = "Номер паспорта", value = {"--number", "-n"})
            String number
    ){
        userService.removeByPassport(serial, number);
        terminal.writer().println("Пользователь удален");
    }
}
