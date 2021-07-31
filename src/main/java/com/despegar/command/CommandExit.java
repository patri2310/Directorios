package com.despegar.command;


import com.despegar.tree.Dir;

public class CommandExit implements Command {
    private final String name;

    public CommandExit(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Command{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public void execute(Dir actualDir) {
        Command.printString(this.toString());
    }

    @Override
    public void execute(Dir actualDir, String parameter) { Command.printString(this.toString()); }
}
