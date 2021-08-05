package com.despegar.command;

import com.despegar.tree.Dir;
import com.despegar.tree.DirManager;

import java.util.Optional;

public class Cd implements Command{

    private String name;
    private Optional<String> parameter;
    private String pathParameter;
    private Dir allDirs;

    private DirManager dirManager = new DirManager();

    public Cd(String name, Optional<String> parameter, String pathParameter) {
        this.name = name;
        this.parameter = parameter;
        this.pathParameter = pathParameter;

        this.allDirs = dirManager.getAllDir();
    }

    @Override
    public Dir execute() {
        System.out.printf("actual parameter: %s%n%n", this.getParameter());
        System.out.printf("actual pathParameter: %s%n%n", this.getPathParameter());
        if(this.getPathParameter().equals("/")){
            return this.allDirs;
        }
        return null;
    }

    @Override
    public Optional<String> getParameter() {
        return this.parameter;
    }

    @Override
    public String getPathParameter() {
        return this.pathParameter;
    }
}
