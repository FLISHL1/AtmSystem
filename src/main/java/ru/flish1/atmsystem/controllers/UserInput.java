package ru.flish1.atmsystem.controllers;

public interface UserInput {
    String handleUserActions(String text);

    void checkExitCommand(String text);

    String getCommandExit();
}
