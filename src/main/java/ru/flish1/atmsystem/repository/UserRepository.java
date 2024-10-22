package ru.flish1.atmsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.flish1.atmsystem.entity.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "select u from User u where u.profile.numberPassport = :number and u.profile.seriesPassport = :series")
    Optional<User> findByPassport(String series, String number);

    @Modifying
    @Query(value = "delete User u where u.profile.numberPassport = :number and u.profile.seriesPassport = :series")
    void deleteByPassport(String series, String number);
}
