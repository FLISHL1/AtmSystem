package ru.flish1.atmsystem.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import ru.flish1.atmsystem.entity.Profile;

@Getter
@AllArgsConstructor
@Builder
public class UserDto {

    private String firstName;

    private String lastName;

    private String secondName;

    private Profile profile;

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Имя: ").append(firstName).append("\n");
        stringBuilder.append("Фамилия: ").append(lastName).append("\n");
        stringBuilder.append("Отчество: ");
        if (secondName == null || secondName.isBlank()) {
            stringBuilder.append("не указанно");
        } else {
            stringBuilder.append(secondName);
        }
        stringBuilder.append("\n");
        stringBuilder.append("Серия паспорта: ").append(profile.getSeriesPassport()).append("\n");
        stringBuilder.append("Номер паспорта: ").append(profile.getNumberPassport()).append("\n");
        stringBuilder.append("СНИЛС: ");
        if (profile.getSnils() == null || profile.getSnils().isBlank()) {
            stringBuilder.append("не указанно");
        } else {
            stringBuilder.append(profile.getSnils());
        }
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}
