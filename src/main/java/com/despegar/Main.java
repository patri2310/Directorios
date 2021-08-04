package com.despegar;

import com.despegar.command.Command;
import com.despegar.command.CommandFactory;
import com.despegar.command.Exit;


public class Main {

    private static final CommandFactory commandFactory = new CommandFactory();

    public static void main(String[] args) {
        enterCommand();
    }

    private static void enterCommand() {
        Command command = commandFactory.createCommand();
        if (command != null) {
            if(!(command instanceof Exit)) {
                command.execute(command.getPathParameter());
                enterCommand();
            }
        }

    }

}
