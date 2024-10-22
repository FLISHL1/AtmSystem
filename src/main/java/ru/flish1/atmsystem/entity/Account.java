package ru.flish1.atmsystem.entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Double balance = 0.0;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private User holder;

    @Column(nullable = false)
    private String pin;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
    private List<AccountTransaction> accountTransactions = new ArrayList<>();


    public Account() {
    }

    public Account(Long id, String title, Double balance, User holder, String pin, List<AccountTransaction> accountTransactions) {
        this.id = id;
        this.title = title;
        this.balance = balance;
        this.holder = holder;
        this.pin = pin;
        this.accountTransactions = accountTransactions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public User getHolder() {
        return holder;
    }

    public void setHolder(User holder) {
        this.holder = holder;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public List<AccountTransaction> getAccountTransactions() {
        return accountTransactions;
    }

    public void setAccountTransactions(List<AccountTransaction> accountTransactions) {
        this.accountTransactions = accountTransactions;
    }
}
