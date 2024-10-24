package ru.flish1.atmsystem.mapper;

import org.mapstruct.Mapper;
import ru.flish1.atmsystem.dto.UserDto;
import ru.flish1.atmsystem.entity.User;
import java.util.List;

@Mapper(componentModel = "spring")
public interface UserDtoMapper {
    User userDtoToUser(UserDto userDto);
    List<User> usersDtoToUsers(List<UserDto> usersDto);
    UserDto userToUserDto(User user);
    List<UserDto> usersToUsersDto(List<User> users);
}
