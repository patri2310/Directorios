package com.despegar.command;


import com.despegar.tree.Dir;

import java.util.Optional;

public class Exit implements Command {
    private String name;
    private String pathParameter;

    public Exit(String name, String pathParameter) {
        this.name = name;
        this.pathParameter = pathParameter;
    }

    @Override
    public String toString() {
        return "Command{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public String getPathParameter() {
        return this.pathParameter;
    }


    @Override
    public Dir execute(String dirActual) {
        Command.printString(this.toString());
        return Dir.builder().name(dirActual).build();
    }

    @Override
    public Optional<String> getParameter() {
        return Optional.empty();
    }

    @Override
    public String getName() {
        return this.name;
    }

}
