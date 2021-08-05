package com.despegar.command;

import java.util.Optional;
import java.util.Scanner;

public class CommandManager {

    public Command createCommand(){

        String enteredCommand = getCommand().toLowerCase();

        String recursive = "-r";
        String back = "..";
        String slash = "/";

        Optional<String> parameter = Optional.empty();

        String firstCommand;
        String secondCommand = null;

        if(enteredCommand.contains(recursive)){
            parameter = Optional.of(recursive);
            String[] strings = enteredCommand.split(recursive);
            firstCommand = strings[0].trim();
            secondCommand = strings.length>1?strings[1].trim(): slash;
        }
        else {
            firstCommand = enteredCommand.trim();
            if(enteredCommand.contains(back)){
                firstCommand = enteredCommand.substring(0, enteredCommand.indexOf(back)).trim();
                parameter = Optional.of(back);
            }
        }

        String path = slash;
        int positionFirstSlash = firstCommand.indexOf(slash);
        if(positionFirstSlash>0){
            path = firstCommand.substring(positionFirstSlash+1).trim();
            firstCommand = firstCommand.substring(0, positionFirstSlash).trim();
        }
        else
            if(secondCommand != null){
                int positionSlash = secondCommand.indexOf(slash);
                if(positionSlash>0){
                    path = secondCommand.substring(positionSlash+1).trim();
                }
        }

        System.out.printf("command: %s - ", firstCommand);
        System.out.printf("parameter: %s%n%n", parameter);
        System.out.printf("path: %s%n%n", path);

        switch (firstCommand) {
            case "ls":
                return new Ls("ls", parameter, path);
            case "cd":
                return new Cd("cd", parameter, path);
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
