package ru.flish1.atmsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "banks",
    uniqueConstraints = @UniqueConstraint(
            columnNames = {"title"}
    ))
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_id")
    private List<Account> clients;


}

