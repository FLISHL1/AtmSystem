package ru.flish1.atmsystem.entity;



import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users",
uniqueConstraints = @UniqueConstraint(
        columnNames = {"series_passport", "number_passport"}
))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "second_name")
    private String secondName;

    @Embedded
    private Profile profile;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "holder")
    private List<Account> accounts;

    @ManyToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    @ColumnDefault(value = "1")
    private Bank bank;

    public User() {
        this.profile = new Profile();
    }

    public User(Long id, String firstName, String lastName, String secondName, Profile profile, List<Account> accounts, Bank bank) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.secondName = secondName;
        this.profile = profile;
        this.accounts = accounts;
        this.bank = bank;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(secondName, user.secondName);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", profile=" + profile +
                ", accounts=" + accounts +
                ", bank=" + bank +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, secondName);
    }
}
