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
    public Optional<String> getParameter() {
        return Optional.empty();
    }

    @Override
    public Dir execute() {
        Command.printString(this.toString());
        return Dir.builder().name(getPathParameter()).build();
    }





}
