package ru.flish1.atmsystem.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.flish1.atmsystem.entity.Bank;
import ru.flish1.atmsystem.exception.BankNotFoundException;
import ru.flish1.atmsystem.repository.BankRepository;

@RequiredArgsConstructor
@Service
@Slf4j
public class BankService {
    private final BankRepository bankRepository;

    public Bank create(Bank bank) {
        return bankRepository.save(bank);
    }

    public Bank getByTitle(String title) {
        return bankRepository.findByTitle(title).orElseThrow(() -> {
                    BankNotFoundException exception = new BankNotFoundException("Банк с таким названием не найден " + title);
                    log.error(exception.getMessage());
                    return exception;
                });
    }
}
