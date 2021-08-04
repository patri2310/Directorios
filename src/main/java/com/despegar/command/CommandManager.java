package com.despegar.command;

import java.util.Optional;
import java.util.Scanner;

public class CommandManager {

    private Optional<String> parameter = Optional.empty();
    private String firstCommand = null;

    public static String getCommand() {
        Scanner sc = new Scanner(System.in);
        System.out.print(">");
        return sc.nextLine();
    }


    public Optional<String> getParameter() {
        return parameter;
    }

    public void setParameter(Optional<String> parameter) {
        this.parameter = parameter;
    }

    public String getFirstCommand() {
        return firstCommand;
    }

    public void setFirstCommand(String firstCommand) {
        this.firstCommand = firstCommand;
    }
}
