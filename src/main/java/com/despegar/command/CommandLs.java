package com.despegar.command;

import com.despegar.tree.Dir;

import java.util.Optional;

public class CommandLs implements Command {
    private final String name;

    public CommandLs(String name) {
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
        execute(actualDir, null);
    }

    public void execute(Dir actualDir, String parameter) {
        Optional<Dir> foundDir = search(actualDir, TREE_FACTORY);
        if (foundDir.isPresent()) {
            Dir someDir = foundDir.get();
            if (parameter != null && parameter.equals("-r")) {
                printTree(someDir);
            } else {
                printFiles(someDir);
            }
        } else Command.printString("No encontró directorio " + actualDir.getName());
    }

    private Optional<Dir> search(Dir actualDir, Dir tree) {
        if (actualDir.getName().equals("/")) return Optional.of(TREE_FACTORY);
        Optional<Dir> dirSearched = tree.getDirs().stream().filter(dir -> dir.getName().equals(actualDir.getName())).findAny();
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

    public void printFiles(Dir actualDir) {
        actualDir.getFiles().forEach(file -> Command.printString(file.getName() + " - " + file.getSize()));
    }
}
