package com.despegar.command;

import java.util.Optional;

public class CommandFactory {

    private static final CommandManager commandManager = new CommandManager();

    public Command createCommand(){

        String enteredCommand = CommandManager.getCommand();
        String[] commands = enteredCommand.split("/");
        String recursive = "-r";
        Optional<String> parameter = Optional.empty();
        String firstCommand = commands[0].trim();

        if(commands[0].contains(recursive)){
           firstCommand = commands[0].split(recursive)[0].trim();
           parameter =  Optional.of(recursive);
       }


        String nameDir = commands.length>1 && commands[1]!=null ? commands[1] : "/";

        System.out.printf("enteredCommand: %s%n", firstCommand);
        System.out.printf("parameter: %s%n", parameter);

        switch (firstCommand) {
            case "ls":
                return new Ls("ls", parameter, nameDir);
            case "exit":
                return new Exit("exit", nameDir);
            default:
                return null;
        }
    }
}
