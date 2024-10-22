package ru.flish1.atmsystem.controllers;

import java.util.Scanner;

public class ConsoleUserInput implements UserInput{
    private final Scanner sc;
    private final String COMMAND_EXIT;

    public ConsoleUserInput() {
        this(new Scanner(System.in), "exit");
    }

    public ConsoleUserInput(Scanner scanner, String commandExit){
        this.COMMAND_EXIT = commandExit;
        this.sc = scanner;
    }

    public String getCommandExit() {
        return COMMAND_EXIT;
    }

    @Override
    public String handleUserActions(String text) {
        System.out.print(text);
        String userText = sc.nextLine();

        return userText.strip();

    }

    @Override
    public void checkExitCommand(String text) {
        if (text.strip().equals(COMMAND_EXIT)) {
            System.exit(0);
        }
    }

}
