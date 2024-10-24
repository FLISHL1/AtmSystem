package ru.flish1.atmsystem.mapper;

import org.junit.jupiter.api.Test;
import ru.flish1.atmsystem.dto.UserDto;
import ru.flish1.atmsystem.entity.Profile;
import ru.flish1.atmsystem.entity.User;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserDtoMapperTest {

    private final UserDtoMapper userDtoMapper;

    public UserDtoMapperTest(UserDtoMapper userDtoMapper) {
        this.userDtoMapper = userDtoMapper;
    }

    @Test
    public void testUserDtoToUser() {
        // Подготовка данных
        Profile profile = new Profile("123-456-789 01", "123456", "1234");
        UserDto userDto = new UserDto(
                "John",
                "Doe",
                "Smith",
                profile);

        // Вызов метода
        User user = userDtoMapper.userDtoToUser(userDto);

        // Проверка результатов
        assertEquals("John", user.getFirstName());
        assertEquals("Doe", user.getLastName());
        assertEquals("Smith", user.getSecondName());
        assertEquals(profile, user.getProfile());
    }

    @Test
    public void testUserToUserDto() {
        // Подготовка данных
        Profile profile = new Profile("123-456-789 01", "123456", "1234");
        User user = new User();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setSecondName("Smith");
        user.setProfile(profile);

        // Вызов метода
        UserDto userDto = userDtoMapper.userToUserDto(user);

        // Проверка результатов
        assertEquals("John", userDto.firstName());
        assertEquals("Doe", userDto.lastName());
        assertEquals("Smith", userDto.secondName());
        assertEquals(profile, userDto.profile());
    }
}
