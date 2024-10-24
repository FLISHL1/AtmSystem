package ru.flish1.atmsystem.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.flish1.atmsystem.dto.AccountRegisterDto;
import ru.flish1.atmsystem.entity.Account;
import ru.flish1.atmsystem.entity.Bank;
import ru.flish1.atmsystem.entity.Profile;
import ru.flish1.atmsystem.entity.User;
import ru.flish1.atmsystem.mapper.AccountRegisterDtoMapper;
import ru.flish1.atmsystem.repository.AccountRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountService {
    private final AccountRepository accountRepository;
    private final UserService userService;
    private final BankService bankService;
    private final AccountRegisterDtoMapper accountRegisterDtoMapper;

    @Transactional
    public AccountRegisterDto create(AccountRegisterDto accountDto) {
        Profile profileHolder = accountDto.holderProfile();
        User user = userService.getByPassport(profileHolder.getSeriesPassport(), profileHolder.getNumberPassport());
        log.info("Получили пользователя {} {}", profileHolder.getSeriesPassport(), profileHolder.getNumberPassport());
        Bank bank = bankService.getByTitle(accountDto.bankTitle());
        log.info("Получили банк {}", accountDto.bankTitle());
        Account account = accountRegisterDtoMapper.accountDtoToAccount(accountDto);
        log.info("Смаппили счет {}", account.getTitle());
        account.setHolder(user);
        account.setBank(bank);
        return accountRegisterDtoMapper.accountToAccountDto(accountRepository.save(account));
    }
}
