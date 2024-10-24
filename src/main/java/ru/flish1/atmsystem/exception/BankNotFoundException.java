package ru.flish1.atmsystem.exception;

public class BankNotFoundException extends RuntimeException{

    public BankNotFoundException(String message) {
        super(message);
    }
}
