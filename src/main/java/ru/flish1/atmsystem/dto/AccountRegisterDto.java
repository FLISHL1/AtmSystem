package ru.flish1.atmsystem.dto;

import ru.flish1.atmsystem.entity.Profile;

import java.math.BigDecimal;

public record AccountRegisterDto(
        String title,
        BigDecimal balance,
        Profile holderProfile,
        String pin,
        String bankTitle
) {
    public AccountRegisterDto(String title, Profile holderProfile, String pin, String bankTitle) {
        this(title, null, holderProfile, pin, bankTitle);
    }

    @Override
    public String toString() {
        return "AccountRegisterDto{" +
                "title='" + title + "'\n''" +
                ", balance=" + balance +
                ", holderProfile=" + holderProfile +
                ", pin='" + pin + "'\n''" +
                ", bankTitle='" + bankTitle + '\'' +
                '}';
    }
}
