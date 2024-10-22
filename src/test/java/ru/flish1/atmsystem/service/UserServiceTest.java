package ru.flish1.atmsystem.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.flish1.atmsystem.dto.UserDto;
import ru.flish1.atmsystem.entity.Profile;
import ru.flish1.atmsystem.entity.User;
import ru.flish1.atmsystem.mapper.UserDtoMapper;
import ru.flish1.atmsystem.repository.UserRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserServiceTest {

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private UserDtoMapper userDtoMapper;

    @Autowired
    private UserService userService;

    @Test
    public void testCreate() {
        // Подготовка данных
        Profile profile = new Profile("123-456-789 01", "123456", "1234");
        UserDto userDto = UserDto.builder()
                .firstName("John")
                .lastName("Doe")
                .secondName("Smith")
                .profile(profile)
                .build();

        User user = new User();
        user.setId(1L);
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setSecondName("Smith");
        user.setProfile(profile);

        // Настройка моков
        when(userDtoMapper.userDtoToUser(userDto)).thenReturn(user);
        when(userRepository.save(user)).thenReturn(user);
        when(userDtoMapper.userToUserDto(user)).thenReturn(userDto);

        // Вызов метода
        UserDto createdUserDto = userService.create(userDto);

        // Проверка результатов
        assertEquals("John", createdUserDto.getFirstName());
        assertEquals("Doe", createdUserDto.getLastName());
        assertEquals("Smith", createdUserDto.getSecondName());
        assertEquals(profile.getNumberPassport(), createdUserDto.getProfile().getNumberPassport());
        assertEquals(profile.getSeriesPassport(), createdUserDto.getProfile().getSeriesPassport());
        assertEquals(profile.getSnils(), createdUserDto.getProfile().getSnils());
    }
}
