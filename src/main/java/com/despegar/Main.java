package com.despegar;

import com.despegar.command.Command;
import com.despegar.command.CommandExit;
import com.despegar.command.CommandLs;
import com.despegar.command.CommandManager;


public class Main {

    private static final CommandManager commandManager = new CommandManager();

    public static void main(String[] args) {
        enterCommand();
    }

    private static void enterCommand() {

        String enteredCommand = CommandManager.getCommand();
        commandManager.analyze(enteredCommand);

        System.out.printf("enteredCommand: %s%n", commandManager.getFirstCommand());
        System.out.printf("parameter: %s%n", commandManager.getParameter());
        System.out.printf("directorio actual: %s%n%n", commandManager.getActualDir().getName());

        boolean valid = true;

        Command command = null;
        switch (commandManager.getFirstCommand()) {
            case "ls":
                command = new CommandLs("ls");
                break;
            case "exit":
                command = new CommandExit("exit");
                break;
            default:
                valid = false;
        }

        if (valid) {
            if (commandManager.getParameter() == null) command.execute(commandManager.getActualDir());
            else command.execute(commandManager.getActualDir(), commandManager.getParameter());
            if (!enteredCommand.equals("exit")) enterCommand();
        }

    }


}
