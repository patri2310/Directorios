package com.despegar.command;

import com.despegar.tree.Dir;

import java.util.Scanner;

public class CommandManager {

    private Dir actualDir = Dir.builder().name("/").build();
    private String parameter = null;
    private String firstCommand = null;

    public void analyze(String enteredCommand) {

        String[] strings = enteredCommand.split("/");

        if (enteredCommand.contains("ls")) {
            updateActualDir(strings);
            setFirstCommand(strings[0].trim());

            String recursiveParam = "-r";
            if (enteredCommand.contains(recursiveParam)) {
                String[] strings0 = enteredCommand.split(recursiveParam);
                setFirstCommand(strings0[0].trim());
                setParameter(recursiveParam);
            } else {
                setParameter(null);
            }
        } else {
            setFirstCommand(enteredCommand);
        }

    }

    public Dir getActualDir() {
        return this.actualDir;
    }

    public void setActualDir(Dir actualDir) {
        this.actualDir = actualDir;
    }

    public static String getCommand() {
        Scanner sc = new Scanner(System.in);
        System.out.print(">");
        return sc.nextLine();
    }

    private void updateActualDir(String[] strings) {
        if (strings.length == 2) {
            setActualDir(Dir.builder().name(strings[1].trim()).build());

        } else if (strings.length == 1) {
            setActualDir(Dir.builder().name("/").build());
        }
    }

    public String getParameter() {
        return this.parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getFirstCommand() {
        return firstCommand;
    }

    public void setFirstCommand(String firstCommand) {
        this.firstCommand = firstCommand;
    }
}
