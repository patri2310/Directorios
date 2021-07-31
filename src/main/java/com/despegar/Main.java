package com.despegar;

import com.despegar.command.CommandFactory;
import com.despegar.command.CommandManager;


public class Main {

    private static final CommandManager commandManager = new CommandManager();
    private static final CommandFactory commandFactory = new CommandFactory();
    public static void main(String[] args) {
        enterCommand();
    }

    private static void enterCommand() {
        if(commandFactory.createCommand()) enterCommand();
    }

}
