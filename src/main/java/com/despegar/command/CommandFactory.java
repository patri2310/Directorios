package com.despegar.command;

import com.despegar.tree.Dir;

public class CommandFactory {

    private static final CommandManager commandManager = new CommandManager();

    public boolean createCommand(){

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

            return !enteredCommand.equals("exit");
        }
        return false;
    }
}
