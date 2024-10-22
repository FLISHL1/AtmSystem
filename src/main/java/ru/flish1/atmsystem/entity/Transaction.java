package ru.flish1.atmsystem.entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * <p>Транзакции об операциях типа: перевод, пополнение, снятие</p>
 * Содержит такие поля как
 * <ul>
 *     <li>amount - сумма транзакции</li>
 *
 * </ul>
 */
@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Double amount;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "transaction")
    private List<AccountTransaction> accountTransactions = new ArrayList<>();

    public Transaction(){}

    public Transaction(Long id, String title, Double amount, List<AccountTransaction> accountTransactions) {
        this.id = id;
        this.title = title;
        this.amount = amount;
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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public List<AccountTransaction> getAccountTransactions() {
        return accountTransactions;
    }

    public void setAccountTransactions(List<AccountTransaction> accountTransactions) {
        this.accountTransactions = accountTransactions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(id, that.id) && Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }
}
