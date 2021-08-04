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
        Optional<Dir> foundDir = search(actualDir, dirManager.getAllDir());
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

    private Optional<Dir> search(String actualDir, Dir tree) {
        if (actualDir.equals("/")) return Optional.of(dirManager.getAllDir());
        Optional<Dir> dirSearched = tree.getDirs().stream().filter(dir -> dir.getName().equals(actualDir)).findAny();
        if (dirSearched.isPresent()) {
            return dirSearched;
        } else {
            final Dir[] searched = {null};
            tree.getDirs().forEach(dirNew -> {
                if (searched[0] == null) {
                    Optional<Dir> optionalDir = search(actualDir, dirNew);
                    optionalDir.ifPresent(dir -> searched[0] = dir);
                }
            });
            if (searched[0] != null) return Optional.of(searched[0]);
            else return Optional.empty();
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
