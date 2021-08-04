package com.despegar.command;

import com.despegar.tree.Dir;

import java.util.Optional;

public interface Command {
    Dir execute();
    Optional<String> getParameter();
    String getPathParameter();
    static void printString(String text) {
        System.out.print(text + "\n");
    }
}
