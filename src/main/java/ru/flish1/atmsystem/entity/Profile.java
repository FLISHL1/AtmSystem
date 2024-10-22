package ru.flish1.atmsystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Embeddable
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Profile {

    @Column(name = "snils")
    private String snils;


    @Column(name = "number_passport", nullable = false)
    @NotNull
    private String numberPassport;

    @Column(name = "series_passport", nullable = false)
    @NotNull
    private String seriesPassport;

}

