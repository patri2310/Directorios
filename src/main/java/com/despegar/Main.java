package com.despegar;

import com.despegar.command.Command;
import com.despegar.command.CommandExit;
import com.despegar.command.CommandLs;
import com.despegar.tree.Dir;

import java.util.Scanner;

public class Main {

    private static Dir actualDir = Dir.builder().name("/").build();

    public static void main(String[] args) {
        enterCommand();
    }

    private static void enterCommand() {
        String parameter = null;
        String enteredCommand = getCommand();

        String[] strings = enteredCommand.split("/");

        if (enteredCommand.contains("ls")) {
            updateActualDir(strings);

            enteredCommand = strings[0].trim();

            if (enteredCommand.contains("-r")) {
                String[] strings0 = enteredCommand.split("-r");
                enteredCommand = strings0[0].trim();
                parameter = "-r";
            }
        }

        System.out.printf("enteredCommand: %s%n", enteredCommand);
        System.out.printf("name: %s%n", actualDir.getName());

        boolean valid = true;
        Command command = null;

        switch (enteredCommand) {
            case "ls":
                command = new CommandLs("ls");
                break;
            case "exit":
                command = new CommandExit("exit");
                break;
            default:
                valid = false;
        }

        if (valid){
            if (parameter == null) command.execute(getActualDir());
            else command.execute(getActualDir(), parameter);
            if (!enteredCommand.equals("exit")) enterCommand();
        }

    }

    private static void updateActualDir(String[] strings) {
        if (strings.length == 2) {
            setActualDir(Dir.builder().name(strings[1].trim()).build());

        } else if (strings.length == 1) {
            setActualDir(Dir.builder().name("/").build());
        }
    }

    private static String getCommand() {
        Scanner sc = new Scanner(System.in);
        System.out.print(">");
        return sc.nextLine();
    }

    public static Dir getActualDir() {
        return actualDir;
    }

    public static void setActualDir(Dir actualDir) {
        Main.actualDir = actualDir;
    }
}
