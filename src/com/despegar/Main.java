package com.despegar;

import com.despegar.command.CommandExit;
import com.despegar.command.CommandLs;
import com.despegar.tree.Dir;

import java.util.Scanner;

public class Main {

    private static final CommandExit exit = new CommandExit("exit");
    private static final CommandLs ls = new CommandLs("ls");
    private static Dir actualDir = Dir.builder().name("/").build();

    public static void main(String[] args) {
        enterCommand();
    }

    private static void enterCommand() {
        Scanner sc = new Scanner(System.in);
        System.out.print(">");
        String command = sc.nextLine();
        String parameter = null;

        String[] strings = command.split("/");


        if (command.contains("ls")) {
            if (strings.length == 2) {
                actualDir = Dir.builder().name(strings[1].trim()).build();

            } else if (strings.length == 1) {
                actualDir = Dir.builder().name("/").build();
            }
            command = strings[0].trim();

            if (command.contains("-r")) {
                String[] strings0 = command.split("-r");
                command = strings0[0].trim();
                parameter = "-r";
            }
        }

        System.out.printf("command: %s%n", command);
        System.out.printf("name: %s%n", actualDir.getName());


        switch (command) {
            case "ls":
                if (parameter == null) ls.execute(actualDir);
                else ls.execute(actualDir, parameter);
                break;
            case "exit":
                exit.execute(actualDir);
                break;
            default:
                command = "error";
        }
        if (!command.equals("error") && !command.equals("exit")) enterCommand();
    }


}
