package ru.flish1.atmsystem.mapper;

import org.springframework.stereotype.Component;
import ru.flish1.atmsystem.dto.UserDto;
import ru.flish1.atmsystem.entity.User;

@Component
public class UserDtoMapper {
    public User userDtoToUser(UserDto userDto){
        User user = new User();
        user.setProfile(userDto.getProfile());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setSecondName(userDto.getSecondName());
        return user;
    }
    public UserDto userToUserDto(User user){
        return new UserDto(
                user.getFirstName(),
                user.getLastName(),
                user.getSecondName(),
                user.getProfile()
        );
    }
}
