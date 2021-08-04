package com.despegar.command;

import java.util.Optional;
import java.util.Scanner;

public class CommandManager {

    public Command createCommand(){

        String enteredCommand = getCommand().toLowerCase();
        String[] commands = enteredCommand.split("/");
        String recursive = "-r";
        Optional<String> parameter = Optional.empty();
        String firstCommand = commands[0].trim();

        if(commands[0].contains(recursive)){
           firstCommand = commands[0].split(recursive)[0].trim();
           parameter =  Optional.of(recursive);
       }

        String path = commands.length > 1 && commands[1] != null ? commands[1] : "/";

        System.out.printf("command: %s - ", firstCommand);
        System.out.printf("parameter: %s%n%n", parameter);

        switch (firstCommand) {
            case "ls":
                return new Ls("ls", parameter, path);
            case "exit":
                return new Exit("exit", path);
            default:
                return null;
        }
    }

    private String getCommand() {
        Scanner sc = new Scanner(System.in);
        System.out.print(">");
        return sc.nextLine();
    }
}
