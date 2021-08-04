package com.despegar;

import com.despegar.command.Command;
import com.despegar.command.CommandManager;
import com.despegar.command.Exit;


public class Main {

    private static final CommandManager commandManager = new CommandManager();

    public static void main(String[] args) {
        enterCommand();
    }

    private static void enterCommand() {
        Command command = commandManager.createCommand();
        if (command != null) {
            command.execute();
            if(!(command instanceof Exit)) {
                enterCommand();
            }
        }

    }

}
