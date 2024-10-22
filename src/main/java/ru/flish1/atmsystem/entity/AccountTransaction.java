package ru.flish1.atmsystem.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "account_transactions")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AccountTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn(name = "account_id")
    private Account account;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn(name = "transaction_id")
    private Transaction transaction;

    @Column(name = "create_at")
    private Instant createAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransaction that = (AccountTransaction) o;
        return Objects.equals(account, that.account) && Objects.equals(transaction, that.transaction) && Objects.equals(createAt, that.createAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(account, transaction);
    }

    public void setAccount(Account account) {
        this.account = account;
        account.getAccountTransactions().add(this);
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
        transaction.getAccountTransactions().add(this);
    }

}
