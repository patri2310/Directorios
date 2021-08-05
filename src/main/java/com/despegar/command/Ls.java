package com.despegar.command;

import com.despegar.tree.Dir;
import com.despegar.tree.DirManager;

import java.util.Optional;

public class Ls implements Command {
    private String name;
    private Optional<String> parameter;
    private String pathParameter;

    private DirManager dirManager = new DirManager();

    public Ls(String name, Optional<String> parameter, String pathParameter) {
        this.name = name;
        this.parameter = parameter;
        this.pathParameter = pathParameter;
    }

    @Override
    public String getPathParameter() {
        return this.pathParameter;
    }

    @Override
    public Optional<String> getParameter() {
        return this.parameter;
    }

    @Override
    public String toString() {
        return "Command{" +
                "name='" + name + '\'' +
                '}';
    }


    public Dir execute() {
        String actualDir = getPathParameter();
        Optional<Dir> foundDir = dirManager.search(actualDir);
        if (foundDir.isPresent()) {
            Dir someDir = foundDir.get();
            if (getParameter().isPresent() && getParameter().get().equals("-r")) {
                printTree(someDir);
            } else {
                printDirs(someDir);
                printFiles(someDir);
            }
            return someDir;
        } else {
            Command.printString("No encontró directorio " + actualDir);
            return null;
        }
    }

    private void printTree(Dir actualDir) {
        printFiles(actualDir);
        actualDir.getDirs().forEach(dirX -> {
            Command.printString("directorio: " + dirX.getName());
            if (!dirX.getDirs().isEmpty()) printTree(dirX);
            else printFiles(dirX);
        });
    }

    private void printDirs(Dir actualDir){
        actualDir.getDirs().forEach(dirX -> Command.printString("directorio: " + dirX.getName()));
    }

    private void printFiles(Dir actualDir) {
        actualDir.getFiles().forEach(file -> Command.printString( "archivo: " + file.getName() + " - " + file.getSize()));
    }

}
