package ru.flish1.atmsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.flish1.atmsystem.entity.Bank;

import java.util.Optional;

public interface BankRepository extends JpaRepository<Bank, Integer> {
    Optional<Bank> findByTitle(String title);
}
