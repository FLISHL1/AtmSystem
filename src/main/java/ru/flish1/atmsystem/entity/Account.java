package ru.flish1.atmsystem.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "accounts")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "balance")
    private BigDecimal balance;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn(name = "holder_id")
    private User holder;

    @Column(name = "pin", nullable = false)
    private String pin;

    @ManyToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn(name = "bank_id")
    @ColumnDefault(value = "1")
    private Bank bank;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
    private List<AccountTransaction> accountTransactions = new ArrayList<>();


}
