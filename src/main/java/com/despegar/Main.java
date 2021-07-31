package com.despegar;

import com.despegar.command.Command;
import com.despegar.command.CommandExit;
import com.despegar.command.CommandLs;
import com.despegar.command.CommandManager;
import com.despegar.tree.Dir;


public class Main {

    private static final CommandManager commandManager = new CommandManager();

    public static void main(String[] args) {
        enterCommand();
    }

    private static void enterCommand() {

        String enteredCommand = CommandManager.getCommand();

        commandManager.analyze(enteredCommand);

        String firstCommand = commandManager.getFirstCommand();
        String parameter = commandManager.getParameter();
        Dir actualDir = commandManager.getActualDir();

        System.out.printf("enteredCommand: %s%n", firstCommand);
        System.out.printf("parameter: %s%n", parameter);
        System.out.printf("directorio actual: %s%n%n", actualDir.getName());

        Command command = null;
        boolean valid = true;
        switch (firstCommand) {
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
            if (parameter == null) command.execute(actualDir);
            else command.execute(actualDir, parameter);
            if (!enteredCommand.equals("exit")) enterCommand();
        }

    }


}
