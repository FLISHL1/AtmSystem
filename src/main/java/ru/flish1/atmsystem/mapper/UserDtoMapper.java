package ru.flish1.atmsystem.mapper;

import org.springframework.stereotype.Component;
import ru.flish1.atmsystem.dto.UserDto;
import ru.flish1.atmsystem.entity.User;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<UserDto> usersToUsersDto(List<User> users){
        return users.stream().map(this::userToUserDto).collect(Collectors.toList());
    }

    public List<User> usersDtoToUsers(List<UserDto> usersDto){
        return usersDto.stream().map(this::userDtoToUser).collect(Collectors.toList());
    }

}
