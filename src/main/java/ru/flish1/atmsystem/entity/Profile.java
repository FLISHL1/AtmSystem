package ru.flish1.atmsystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Profile {

    private Integer snils;


    @Column(name = "number_passport", nullable = false)
    private Integer numberPassport;

    @Column(name = "series_passport", nullable = false)
    private Integer seriesPassport;

    public Integer getSnils() {
        return snils;
    }

    public void setSnils(Integer snils) {
        this.snils = snils;
    }

    public Integer getNumberPassport() {
        return numberPassport;
    }

    public void setNumberPassport(Integer numberPassport) {
        this.numberPassport = numberPassport;
    }

    public Integer getSeriesPassport() {
        return seriesPassport;
    }

    public void setSerialPassport(Integer seriesPassport) {
        this.seriesPassport = seriesPassport;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "snils=" + snils +
                ", numberPassport=" + numberPassport +
                ", seriesPassport=" + seriesPassport +
                '}';
    }
}
