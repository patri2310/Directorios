package com.company;


import com.company.tree.Dir;

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
}
