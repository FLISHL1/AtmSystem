package ru.flish1.atmsystem.entity;


import jakarta.persistence.*;

import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "account_transactions")
public class AccountTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Account account;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Transaction transaction;

    @Column(name = "create_at")
    private Instant createAt;

    @OneToOne
    @JoinColumn(name = "type_transaction")
    private TypeTransaction typeTransaction;

    public AccountTransaction() {
    }

    public AccountTransaction(Long id, Account account, Transaction transaction, Instant createAt, TypeTransaction typeTransaction) {
        this.id = id;
        this.account = account;
        this.transaction = transaction;
        this.createAt = createAt;
        this.typeTransaction = typeTransaction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransaction that = (AccountTransaction) o;
        return Objects.equals(account, that.account) && Objects.equals(transaction, that.transaction) && Objects.equals(createAt, that.createAt) && Objects.equals(typeTransaction, that.typeTransaction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(account, transaction);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
        account.getAccountTransactions().add(this);
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
        transaction.getAccountTransactions().add(this);
    }

    public Instant getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Instant createAt) {
        this.createAt = createAt;
    }

    public TypeTransaction getTypeTransaction() {
        return typeTransaction;
    }

    public void setTypeTransaction(TypeTransaction typeTransaction) {
        this.typeTransaction = typeTransaction;
    }
}
