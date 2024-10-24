package ru.flish1.atmsystem.dto;


import ru.flish1.atmsystem.entity.Profile;


public record UserDto(
        String firstName,
        String lastName,
        String secondName,
        Profile profile
) {

}