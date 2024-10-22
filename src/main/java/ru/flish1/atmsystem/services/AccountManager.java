package ru.flish1.atmsystem.services;

import org.flishl1.entity.Account;

public interface AccountManager {
    Double checkBalance(Account account);

    void deposit(Account account, Double amount);

    void withdraw(Account account, Double amount);

    void transferFunds(Account sender, Account payee, Double amount);
}
